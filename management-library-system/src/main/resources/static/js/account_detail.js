document.addEventListener("DOMContentLoaded", () => {
  // 1. KIỂM TRA TRẠNG THÁI ĐĂNG NHẬP
  const token = localStorage.getItem("libraryToken");
  const userName = localStorage.getItem("libraryUser");
  const userRole = localStorage.getItem("libraryRole");

  // Nếu chưa đăng nhập, đá văng ra trang login
  if (!token) {
    alert("Vui lòng đăng nhập để xem thông tin tài khoản!");
    window.location.href = "login.html";
    return;
  }

  // 2. HIỂN THỊ THÔNG TIN CÁ NHÂN TỪ LOCAL STORAGE
  const fullNameInput = document.getElementById("fullName");
  const emailInput = document.getElementById("email");
  const roleBadge = document.getElementById("displayRole");
  const avatarPreview = document.getElementById("avatarPreview");

  if (fullNameInput) fullNameInput.value = userName;

  if (emailInput) {
    let fakeEmail =
      removeVietnameseTones(userName).replace(/ /g, "").toLowerCase() +
      "@gmail.com";
    emailInput.value = fakeEmail;
  }

  if (roleBadge) {
    if (userRole === "ROLE_ADMIN") roleBadge.textContent = "Quản trị viên";
    else if (userRole === "ROLE_STAFF") roleBadge.textContent = "Nhân viên";
    else roleBadge.textContent = "Độc giả";
  }

  //   2. HIỂN THỊ THÔNG TIN
  const savedAvatar = localStorage.getItem("libraryAvatar_" + userName);
  if (savedAvatar && avatarPreview) {
    avatarPreview.src = savedAvatar;
  } else if (avatarPreview) {
    avatarPreview.src = `https://ui-avatars.com/api/?name=${userName}&background=f0c39f&color=000&size=150`;
  }

  // 3. XỬ LÝ UPLOAD ẢNH ĐẠI DIỆN
  const avatarInput = document.getElementById("avatarInput");
  if (avatarInput) {
    avatarInput.addEventListener("change", function (e) {
      const file = e.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = function (event) {
          const base64Image = event.target.result;
          avatarPreview.src = base64Image;

          // SỬA DÒNG NÀY: Lưu ảnh với key có chứa tên user để không bị ghi đè
          localStorage.setItem("libraryAvatar_" + userName, base64Image);
          alert("Cập nhật ảnh đại diện thành công!");
        };
        reader.readAsDataURL(file);
      }
    });
  }

  // ========================================================
  // 4. GỌI API ĐỂ LƯU THÔNG TIN ĐỔI TÊN VÀO DATABASE
  // ========================================================
  const profileForm = document.getElementById("profileForm");
  if (profileForm) {
    profileForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const newName = fullNameInput.value.trim();

      if (newName === "") {
        alert("Họ và tên không được để trống!");
        return;
      }

      // Gọi API gửi Tên mới lên Server
      fetch("http://localhost:8086/api/account/change-info", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`, // Gửi kèm token để bảo mật
        },
        body: JSON.stringify({ fullName: newName }),
      })
        .then((response) => {
          if (!response.ok) {
            return response.json().then((err) => {
              throw err;
            });
          }
          return response.json();
        })
        .then((data) => {
          // Thành công: Server đã lưu vào DB. Giờ ta lưu tên mới vào localStorage
          localStorage.setItem("libraryUser", data.newFullName);
          alert(data.message);
        })
        .catch((error) => {
          console.error("Lỗi API Đổi Tên:", error);
          alert(error.message || "Cập nhật thông tin thất bại!");
        });
    });
  }

  // ========================================================
  // 5. GỌI API ĐỂ ĐỔI MẬT KHẨU TRONG DATABASE
  // ========================================================
  const passwordForm = document.getElementById("passwordForm");
  if (passwordForm) {
    passwordForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const currentPass = document.getElementById("currentPassword").value;
      const newPass = document.getElementById("newPassword").value;

      if (newPass.length < 6) {
        alert("Mật khẩu mới phải dài ít nhất 6 ký tự!");
        return;
      }

      if (currentPass === newPass) {
        alert("Mật khẩu mới không được trùng với mật khẩu hiện tại!");
        return;
      }

      // Gọi API Đổi Mật Khẩu
      fetch("http://localhost:8086/api/account/change-password", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify({
          currentPassword: currentPass,
          newPassword: newPass,
        }),
      })
        .then((response) => {
          if (!response.ok) {
            return response.json().then((err) => {
              throw err;
            });
          }
          return response.json();
        })
        .then((data) => {
          alert(data.message);
          passwordForm.reset(); // Xóa sạch ô nhập mật khẩu sau khi đổi thành công
        })
        .catch((error) => {
          console.error("Lỗi API Đổi Mật Khẩu:", error);
          alert(error.message || "Đổi mật khẩu thất bại!");
        });
    });
  }

  function removeVietnameseTones(str) {
    return str
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .replace(/đ/g, "d")
      .replace(/Đ/g, "D");
  }
});
