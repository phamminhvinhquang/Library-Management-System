document.addEventListener("DOMContentLoaded", () => {
  // 1. KIỂM TRA QUYỀN TRUY CẬP
  const token = localStorage.getItem("libraryToken");
  const userRole = localStorage.getItem("libraryRole");

  if (!token || !userRole || userRole === "ROLE_USER") {
    alert(
      "Truy cập bị từ chối! Bạn không có quyền xem trang Quản Lý Tài Khoản.",
    );
    window.location.href = "index.html";
    return;
  }

  // KHỞI TẠO MODAL HTML TRỰC TIẾP VÀO BODY CHO XEM/SỬA
  const modalHTML = `
  <div id="accountModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.5); z-index:9999; align-items:center; justify-content:center;">
      <div style="background:#fff; padding:25px; border-radius:12px; width:450px; max-width:90%; border: 2px solid #eab389;">
          <h3 id="modalTitle" style="margin-bottom:20px; color:#eab389; font-size:22px; text-align:center;">Chi tiết tài khoản</h3>
          <div id="modalContent" style="margin-bottom:20px; font-size:15px; line-height:1.8; color:#2c3e50;"></div>
          <div style="text-align:right;">
              <button onclick="closeModal()" style="padding:10px 20px; border:none; background:#a0978e; color:#fff; border-radius:6px; cursor:pointer;">Đóng</button>
              <button id="btnSaveRole" style="display:none; padding:10px 20px; border:none; background:#eab389; color:#fff; border-radius:6px; cursor:pointer; margin-left:10px;">Lưu Thay Đổi</button>
          </div>
      </div>
  </div>`;
  document.body.insertAdjacentHTML("beforeend", modalHTML);

  const tableBody = document.getElementById("accountTableBody");
  const roleFilter = document.getElementById("roleFilter");
  const searchInput = document.getElementById("searchInput");
  const btnSearch = document.getElementById("btnSearch");
  const btnReset = document.getElementById("btnReset");

  let allAccounts = [];

  // =========================================================
  // 2. GỌI API LẤY DỮ LIỆU TỪ MYSQL
  // =========================================================
  function fetchAccounts() {
    fetch("http://localhost:8086/api/account/all", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        allAccounts = data;
        renderTable(allAccounts);
      })
      .catch((error) => console.error("Lỗi API:", error));
  }

  // =========================================================
  // 3. HÀM HIỂN THỊ DỮ LIỆU LÊN BẢNG VÀ PHÂN QUYỀN NÚT
  // =========================================================
  function renderTable(data) {
    tableBody.innerHTML = "";

    if (data.length === 0) {
      tableBody.innerHTML = `<tr><td colspan="6" style="text-align: center;">Không tìm thấy tài khoản nào.</td></tr>`;
      return;
    }

    data.forEach((acc) => {
      let roleBadge = "";
      let roleName = "";
      if (acc.role === "ROLE_ADMIN") {
        roleBadge = "badge-admin";
        roleName = "Admin";
      } else if (acc.role === "ROLE_STAFF") {
        roleBadge = "badge-staff";
        roleName = "Nhân viên";
      } else {
        roleBadge = "badge-user";
        roleName = "Độc giả";
      }

      // LOGIC XÁC ĐỊNH QUYỀN HIỂN THỊ NÚT THAO TÁC
      const canOperate =
        (userRole === "ROLE_ADMIN" && acc.role !== "ROLE_ADMIN") ||
        (userRole === "ROLE_STAFF" && acc.role === "ROLE_USER");

      const actionButtons = canOperate
        ? `
             <button class="btn-action btn-view" onclick="viewAccount(${acc.accountID})" title="Xem chi tiết"><iconify-icon icon="ph:eye-bold"></iconify-icon></button>
             <button class="btn-action btn-edit" onclick="editAccount(${acc.accountID})" title="Chỉnh sửa"><iconify-icon icon="ph:pencil-simple-bold"></iconify-icon></button>
             <button class="btn-action btn-delete" onclick="deleteAccount(${acc.accountID})" title="Xóa"><iconify-icon icon="ph:trash-bold"></iconify-icon></button>
            `
        : `<span style="font-size:12px; color:#888; font-style:italic;">Không có quyền</span>`;

      const row = `
                <tr>
                    <td>TK${acc.accountID}</td>
                    <td>${acc.email}</td>
                    <td><span class="badge ${roleBadge}">${roleName}</span></td>
                    <td>${acc.fullName || "N/A"}</td>
                    <td><span class="badge badge-status">Hoạt động</span></td>
                    <td><div class="action-buttons">${actionButtons}</div></td>
                </tr>
            `;
      tableBody.insertAdjacentHTML("beforeend", row);
    });
  }

  // =========================================================
  // 4. CÁC HÀM XỬ LÝ SỰ KIỆN: XEM, SỬA, XÓA
  // =========================================================
  window.closeModal = function () {
    document.getElementById("accountModal").style.display = "none";
  };

  window.viewAccount = function (id) {
    const acc = allAccounts.find((a) => a.accountID === id);
    if (!acc) return;

    let roleText =
      acc.role === "ROLE_ADMIN"
        ? "Quản trị viên"
        : acc.role === "ROLE_STAFF"
          ? "Nhân viên"
          : "Độc giả";

    document.getElementById("modalTitle").innerText = "Thông Tin Chi Tiết";
    document.getElementById("modalContent").innerHTML = `
          <p><strong>Mã Tài Khoản:</strong> TK${acc.accountID}</p>
          <p><strong>Email đăng nhập:</strong> ${acc.email}</p>
          <p><strong>Họ và tên:</strong> ${acc.fullName || "Chưa cung cấp"}</p>
          <p><strong>Số điện thoại:</strong> ${acc.phoneNumber || "Chưa cung cấp"}</p>
          <p><strong>Địa chỉ:</strong> ${acc.address || "Chưa cung cấp"}</p>
          <p><strong>Chức vụ:</strong> <span style="color:#eab389; font-weight:bold;">${roleText}</span></p>
      `;
    document.getElementById("btnSaveRole").style.display = "none";
    document.getElementById("accountModal").style.display = "flex";
  };

  window.editAccount = function (id) {
    const acc = allAccounts.find((a) => a.accountID === id);
    if (!acc) return;

    // Chỉ Admin mới được hiển thị thẻ select để đổi quyền
    let roleSelectHtml = "";
    if (userRole === "ROLE_ADMIN") {
      roleSelectHtml = `
              <select id="editRoleSelect" style="width:100%; padding:10px; margin-top:8px; border-radius:6px; border:1px solid #dcdde1; outline:none;">
                  <option value="ROLE_USER" ${acc.role === "ROLE_USER" ? "selected" : ""}>Độc giả</option>
                  <option value="ROLE_STAFF" ${acc.role === "ROLE_STAFF" ? "selected" : ""}>Nhân viên</option>
              </select>
          `;
    } else {
      roleSelectHtml = `<input type="text" value="Độc giả" disabled style="width:100%; padding:10px; margin-top:8px; border-radius:6px; border:1px solid #dcdde1; background:#f4f5f7; cursor:not-allowed;">
                            <p style="color:#e74c3c; font-size:12px; margin-top:5px;">* Nhân viên không có quyền đổi chức vụ.</p>`;
    }

    document.getElementById("modalTitle").innerText = "Chỉnh Sửa Vai Trò";
    document.getElementById("modalContent").innerHTML = `
          <p><strong>Email Tài Khoản:</strong> ${acc.email}</p>
          <div style="margin-top:15px;">
              <label style="font-weight:600;">Cấp Quyền Mới:</label>
              ${roleSelectHtml}
          </div>
      `;

    const btnSave = document.getElementById("btnSaveRole");
    if (userRole === "ROLE_ADMIN") {
      btnSave.style.display = "inline-block";
      btnSave.onclick = function () {
        const newRole = document.getElementById("editRoleSelect").value;
        updateRole(id, newRole);
      };
    } else {
      btnSave.style.display = "none";
    }

    document.getElementById("accountModal").style.display = "flex";
  };

  function updateRole(id, newRole) {
    fetch(`http://localhost:8086/api/account/${id}/role`, {
      method: "PUT",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ role: newRole }),
    })
      .then((res) =>
        res.json().then((data) => ({ status: res.status, body: data })),
      )
      .then((res) => {
        if (res.status === 200) {
          alert(res.body.message);
          window.closeModal();
          fetchAccounts(); // Render lại bảng ngay lập tức
        } else {
          alert(res.body.message || "Lỗi cập nhật!");
        }
      });
  }

  window.deleteAccount = function (id) {
    if (
      !confirm(
        "⚠️ CẢNH BÁO: Bạn có chắc chắn muốn xóa tài khoản này? Toàn bộ dữ liệu liên quan sẽ bị mất và không thể hoàn tác!",
      )
    )
      return;

    fetch(`http://localhost:8086/api/account/${id}`, {
      method: "DELETE",
      headers: { Authorization: `Bearer ${token}` },
    })
      .then((res) =>
        res.json().then((data) => ({ status: res.status, body: data })),
      )
      .then((res) => {
        if (res.status === 200) {
          alert(res.body.message);
          fetchAccounts();
        } else {
          alert(res.body.message || "Lỗi xóa tài khoản!");
        }
      });
  };

  // =========================================================
  // 5. HÀM TÌM KIẾM VÀ LỌC THEO ROLE CHO CẢ ADMIN VÀ STAFF
  // =========================================================
  function handleSearchAndFilter() {
    const keyword = searchInput.value.toLowerCase().trim();
    const selectedRole = roleFilter.value;

    const results = allAccounts.filter((acc) => {
      const accIdStr = acc.accountID ? acc.accountID.toString() : "";
      const accName = acc.fullName ? acc.fullName.toLowerCase() : "";
      const accEmail = acc.email ? acc.email.toLowerCase() : "";

      const matchKeyword =
        accIdStr.includes(keyword) ||
        accName.includes(keyword) ||
        accEmail.includes(keyword);
      const matchRole = selectedRole === "ALL" || acc.role === selectedRole;

      return matchKeyword && matchRole;
    });

    renderTable(results);
  }

  btnSearch.addEventListener("click", handleSearchAndFilter);
  searchInput.addEventListener("keyup", (e) => {
    if (e.key === "Enter") handleSearchAndFilter();
  });
  btnReset.addEventListener("click", () => {
    searchInput.value = "";
    roleFilter.value = "ALL";
    renderTable(allAccounts);
  });

  fetchAccounts();
});
