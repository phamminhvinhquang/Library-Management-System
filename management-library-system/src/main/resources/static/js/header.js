document.addEventListener("DOMContentLoaded", () => {
  // ==========================================
  // 1. ĐIỀU KHIỂN ĐÓNG/MỞ MENU THỂ LOẠI
  // ==========================================
  const categoryDropdown = document.getElementById("categoryDropdown");
  const categoryMenu = document.getElementById("categoryMenu");

  if (categoryDropdown && categoryMenu) {
    categoryDropdown.addEventListener("click", (e) => {
      e.preventDefault();
      // Bật/tắt trạng thái hiển thị của menu thể loại
      const isHidden =
        categoryMenu.style.display === "none" ||
        categoryMenu.style.display === "";
      categoryMenu.style.display = isHidden ? "block" : "none";
    });

    // Tự động đóng menu thể loại nếu người dùng click ra ngoài khu vực đó
    document.addEventListener("click", (e) => {
      if (!categoryDropdown.contains(e.target)) {
        categoryMenu.style.display = "none";
      }
    });
  }

  // ==========================================
  // 2. ĐIỀU KHIỂN HIỂN THỊ THANH TÌM KIẾM
  // ==========================================
  const searchToggle = document.getElementById("searchToggle");
  const searchInput = document.getElementById("searchInput");

  if (searchToggle && searchInput) {
    searchToggle.addEventListener("click", (e) => {
      e.preventDefault();
      // Thêm class 'active' để thanh input kéo dài ra (đã style trong CSS)
      searchInput.classList.toggle("active");
      if (searchInput.classList.contains("active")) {
        searchInput.focus(); // Tự động trỏ nháy chuột vào ô nhập
      }
    });
    // LƯU Ý: Chức năng gõ từ khóa để lọc sách thực tế đã được xử lý trong book.js
  }

  // ==========================================
  // 3. ĐIỀU KHIỂN TRẠNG THÁI ĐĂNG NHẬP & MENU NGƯỜI DÙNG
  // ==========================================
  const btnLogin = document.getElementById("btnLogin");
  const btnRegister = document.getElementById("btnRegister");
  const userMenu = document.getElementById("userMenu");
  const menuToggle = document.getElementById("menuToggle");
  const userDropdown = document.getElementById("userDropdown");

  // Lấy thông tin người dùng từ LocalStorage
  const token = localStorage.getItem("libraryToken");
  const userName = localStorage.getItem("libraryUser");
  const userRole = localStorage.getItem("libraryRole");
  const savedAvatar = localStorage.getItem("libraryAvatar_" + userName); // LẤY AVATAR TỪ BỘ NHỚ

  // Xử lý giao diện dựa trên trạng thái đăng nhập
  if (token && userName) {
    if (btnLogin) btnLogin.style.display = "none";
    if (btnRegister) btnRegister.style.display = "none";

    if (userMenu) {
      userMenu.style.display = "block";

      let roleDisplay = "Độc giả";
      if (userRole === "ROLE_ADMIN") roleDisplay = "Quản trị viên";
      else if (userRole === "ROLE_STAFF") roleDisplay = "Nhân viên";

      // XỬ LÝ HTML CHO AVATAR (Nếu có ảnh thì hiện ảnh, không thì hiện icon)
      let headerAvatarHtml = savedAvatar
        ? `<img src="${savedAvatar}" style="width: 28px; height: 28px; border-radius: 50%; object-fit: cover;" alt="Avatar">`
        : `<iconify-icon icon="ph:user-circle-fill" style="font-size: 28px; color: #000;"></iconify-icon>`;

      let dropdownAvatarHtml = savedAvatar
        ? `<img src="${savedAvatar}" style="width: 34px; height: 34px; border-radius: 50%; object-fit: cover;" alt="Avatar">`
        : `<iconify-icon icon="ph:user-circle-fill"></iconify-icon>`;

      // Cập nhật giao diện nút Toggle trên Header
      if (menuToggle) {
        menuToggle.innerHTML = `
            ${headerAvatarHtml}
            <span style="margin-left: 8px; font-size: 15px; font-weight: 500; color: #000;">${userName}</span>
        `;
        menuToggle.style.width = "auto";
        menuToggle.style.padding = "0 10px";
        menuToggle.style.border = "none";
        menuToggle.style.background = "transparent";
      }

      // Cập nhật nội dung Dropdown Menu
      if (userDropdown) {
        // 1. Tạo biến chứa các menu yêu cầu quyền quản trị
        let managementMenu = "";

        // 2. Kiểm tra nếu là ADMIN hoặc STAFF thì mới gán nội dung HTML cho các menu này
        if (userRole === "ROLE_ADMIN" || userRole === "ROLE_STAFF") {
          managementMenu = `
            <li>
              <a href="account_management.html"><iconify-icon icon="ph:users-three-fill"></iconify-icon> Quản lý tài khoản</a>
            </li>
            <li>
              <a href="book_management.html"> <iconify-icon icon="ph:books-fill"></iconify-icon>Quản lý sách</a>
            </li>
            <li>
              <a href="borrow_management.html">
                <iconify-icon icon="solar:clipboard-list-linear"></iconify-icon> Quản Lý Mượn sách
              </a>
            </li>
            
          `;
        }

        // 3. Render HTML: Chèn biến managementMenu vào cấu trúc
        userDropdown.innerHTML = `
          <div class="dropdown-header">
            <div class="dropdown-user-info">
              ${dropdownAvatarHtml}
              <span>${userName}</span>
            </div>
            <div class="dropdown-role-badge">${roleDisplay}</div>
          </div>
          
          <div class="dropdown-divider"></div>
          
          <li>
            <a href="account_detail.html"><iconify-icon icon="ph:user-fill"></iconify-icon> Thông tin tài khoản</a>
          </li>
          
          ${managementMenu}
          
          <div class="dropdown-divider"></div>
          
          <li>
            <a href="#" id="btnLogout"><iconify-icon icon="ph:sign-out-bold"></iconify-icon> Đăng xuất</a>
          </li>
        `;
      }
    }
  } else {
    // Trạng thái chưa đăng nhập
    if (btnLogin) btnLogin.style.display = "inline-block";
    if (btnRegister) btnRegister.style.display = "inline-block";
    if (userMenu) userMenu.style.display = "none";
  }

  // Xử lý sự kiện click mở/đóng Menu Người Dùng
  if (menuToggle && userDropdown) {
    menuToggle.addEventListener("click", (e) => {
      e.stopPropagation();
      userDropdown.classList.toggle("show");
    });

    document.addEventListener("click", (e) => {
      if (userMenu && !userMenu.contains(e.target)) {
        userDropdown.classList.remove("show");
      }
    });
  }

  // Xử lý chức năng Đăng Xuất
  const logoutBtn = document.getElementById("btnLogout");
  if (logoutBtn) {
    logoutBtn.addEventListener("click", (e) => {
      e.preventDefault();
      localStorage.removeItem("libraryToken");
      localStorage.removeItem("libraryUser");
      localStorage.removeItem("libraryRole");
      window.location.href = "index.html"; // Reload để giao diện reset về chưa đăng nhập
    });
  }

  // Xử lý chuyển trang cho các nút Đăng nhập / Đăng ký
  if (btnLogin)
    btnLogin.addEventListener(
      "click",
      () => (window.location.href = "login.html"),
    );
  if (btnRegister)
    btnRegister.addEventListener(
      "click",
      () => (window.location.href = "register.html"),
    );
});
