document.addEventListener("DOMContentLoaded", () => {
  const token = localStorage.getItem("libraryToken");
  const userRole = localStorage.getItem("libraryRole");

  // 1. KIỂM TRA QUYỀN TRUY CẬP (Chỉ Admin/Staff mới được vào)
  if (!token || !userRole || userRole === "ROLE_USER") {
    alert("Truy cập bị từ chối! Chỉ nhân viên mới có quyền duyệt mượn sách.");
    window.location.href = "index.html";
    return;
  }

  const tableBody = document.getElementById("borrowTableBody");
  const searchInput = document.getElementById("searchInput");
  const btnSearch = document.getElementById("btnSearch");

  let allLoanDetails = [];

  // Lấy dữ liệu danh sách mượn từ Cơ sở dữ liệu MySQL
  function loadLoansFromServer() {
    fetch("http://localhost:8086/api/loan/all", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => {
        allLoanDetails = data;
        renderTable(allLoanDetails);
      })
      .catch((err) => {
        console.error("Lỗi tải danh sách mượn:", err);
        tableBody.innerHTML = `<tr><td colspan="7" style="color:red; text-align:center; padding:20px;">Lỗi kết nối Server Spring Boot!</td></tr>`;
      });
  }

  // Render dữ liệu lên bảng
  function renderTable(details) {
    tableBody.innerHTML = "";

    if (!details || details.length === 0) {
      tableBody.innerHTML = `<tr><td colspan="7" style="text-align: center; padding: 20px;">Không có phiếu mượn nào trong hệ thống.</td></tr>`;
      return;
    }

    details.forEach((detail) => {
      let statusClass = "";
      if (detail.status === "Chờ Duyệt") statusClass = "status-pending";
      else if (detail.status === "Đang Mượn") statusClass = "status-approved";
      else if (detail.status === "Từ Chối") statusClass = "status-rejected";
      else if (detail.status === "Đã Trả") statusClass = "status-returned";

      // Khởi tạo các nút thao tác tương ứng với từng id dòng chi tiết (detailID)
      let actionButtons = `<button class="btn-act btn-view" onclick="viewTicketDetail(${detail.detailID})"><iconify-icon icon="ph:eye-bold"></iconify-icon> Chi tiết</button>`;

      if (detail.status === "Chờ Duyệt") {
        actionButtons += `
          <button class="btn-act btn-approve" onclick="updateLoanStatus(${detail.detailID}, 'Đang Mượn')"><iconify-icon icon="ph:check-bold"></iconify-icon> Duyệt</button>
          <button class="btn-act btn-reject" onclick="updateLoanStatus(${detail.detailID}, 'Từ Chối')"><iconify-icon icon="ph:x-bold"></iconify-icon> Từ Chối</button>
        `;
      } else if (detail.status === "Đang Mượn") {
        actionButtons += `
          <button class="btn-act btn-return" onclick="updateLoanStatus(${detail.detailID}, 'Đã Trả')"><iconify-icon icon="ph:arrow-u-down-left-bold"></iconify-icon> Đã Trả</button>
        `;
      }

      const borrowerName =
        detail.loanCard && detail.loanCard.borrower
          ? detail.loanCard.borrower.fullName
          : "Ẩn danh";
      const cardCode =
        "PM-" + (detail.loanCard ? detail.loanCard.cardID : detail.detailID);

      tableBody.innerHTML += `
        <tr>
          <td><strong>${cardCode}-${detail.detailID}</strong></td>
          <td>${borrowerName}</td>
          <td>${detail.borrowDate}</td>
          <td>${detail.dueDate}</td>
          <td><strong>1</strong> cuốn</td>
          <td><span class="badge ${statusClass}">${detail.status}</span></td>
          <td><div class="action-buttons">${actionButtons}</div></td>
        </tr>
      `;
    });
  }

  // Thay đổi trạng thái phiếu mượn chính thức thông qua API PUT
  window.updateLoanStatus = function (detailId, newStatus) {
    if (
      newStatus === "Từ Chối" &&
      !confirm("Bạn có chắc chắn muốn TỪ CHỐI yêu cầu mượn này?")
    )
      return;

    fetch(`http://localhost:8086/api/loan/detail/${detailId}/status`, {
      method: "PUT",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ status: newStatus }),
    })
      .then((res) =>
        res.json().then((data) => ({ status: res.status, body: data })),
      )
      .then((res) => {
        if (res.status === 200) {
          alert(res.body.message);
          loadLoansFromServer(); // Tải và làm mới lại dữ liệu bảng ngay tức thì
        } else {
          // Báo lỗi (Ví dụ: Sách hiện đã hết trong kho...)
          alert("Lỗi: " + res.body.message);
        }
      })
      .catch((err) => {
        console.error("Lỗi phê duyệt:", err);
        alert("Không thể kết nối đến máy chủ!");
      });
  };

  // Xem chi tiết cuốn sách nằm trong dòng phiếu mượn
  window.viewTicketDetail = function (detailId) {
    const detail = allLoanDetails.find((d) => d.detailID === detailId);
    if (!detail) return;

    // 1. Xử lý mã phiếu
    const cardCode =
      "PM-" + (detail.loanCard ? detail.loanCard.cardID : detail.detailID);
    document.getElementById("modalTicketId").innerText =
      `${cardCode}-${detail.detailID}`;

    // 2. Lấy thông tin người mượn
    const borrower =
      detail.loanCard && detail.loanCard.borrower
        ? detail.loanCard.borrower
        : {};
    const fullName = borrower.fullName || "Ẩn danh";
    const email = borrower.email || "Đang cập nhật";
    const phone = borrower.phone || "Đang cập nhật";

    // 3. Lấy thông tin sách
    const book = detail.book || {};
    const bookName = book.bookName || "N/A";
    const publisher = book.publisher || "N/A";
    const yearPublish = book.yearPublish || "N/A";

    // 4. Đổ giao diện chia thành 2 khối rõ ràng: Thông tin Độc giả & Thông tin Sách
    document.getElementById("modalTicketBooks").innerHTML = `
      <div style="display: flex; flex-direction: column; gap: 15px;">
          
          <div style="background: #f8f9fa; padding: 15px; border-radius: 8px; border: 1px solid #e0e0e0;">
              <h4 style="margin-bottom: 12px; color: #2196f3; border-bottom: 2px solid #2196f3; display: inline-block; padding-bottom: 4px;">
                  <iconify-icon icon="solar:user-id-linear" style="vertical-align: text-bottom;"></iconify-icon> 
                  Thông Tin Độc Giả
              </h4>
              <div style="display: grid; grid-template-columns: 1fr; gap: 8px; font-size: 14px; color: #333;">
                  <p><strong>Họ và Tên:</strong> ${fullName}</p>
                  <p><strong>Email đăng nhập:</strong> ${email}</p>
                  <p><strong>Số điện thoại:</strong> ${phone}</p>
              </div>
          </div>

          <div style="background: #fff5e6; padding: 15px; border-radius: 8px; border: 1px solid #ffcc80;">
              <h4 style="margin-bottom: 12px; color: #ff9800; border-bottom: 2px solid #ff9800; display: inline-block; padding-bottom: 4px;">
                  <iconify-icon icon="solar:book-bookmark-linear" style="vertical-align: text-bottom;"></iconify-icon> 
                  Chi Tiết Mượn Sách
              </h4>
              <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 10px; font-size: 14px; line-height: 1.6; color: #333;">
                  <p style="grid-column: span 2;"><strong>Tên sách:</strong> ${bookName}</p>
                  <p><strong>Nhà xuất bản:</strong> ${publisher}</p>
                  <p><strong>Năm XB:</strong> ${yearPublish}</p>
                  <p><strong>Ngày mượn:</strong> <span style="color:#2196f3; font-weight:bold;">${detail.borrowDate || "N/A"}</span></p>
                  <p><strong>Ngày trả:</strong> <span style="color:#f44336; font-weight:bold;">${detail.dueDate || "N/A"}</span></p>
              </div>
          </div>

      </div>
    `;

    document.getElementById("ticketDetailModal").style.display = "flex";
  };

  window.closeTicketModal = function () {
    document.getElementById("ticketDetailModal").style.display = "none";
  };

  // Tìm kiếm theo mã dòng phiếu mượn
  btnSearch.addEventListener("click", () => {
    const keyword = searchInput.value.toLowerCase().trim();
    if (!keyword) {
      renderTable(allLoanDetails);
      return;
    }
    const filtered = allLoanDetails.filter((d) =>
      d.detailID.toString().includes(keyword),
    );
    renderTable(filtered);
  });

  searchInput.addEventListener("keyup", (e) => {
    if (e.key === "Enter") btnSearch.click();
    if (e.target.value === "") renderTable(allLoanDetails);
  });

  loadLoansFromServer();
});
