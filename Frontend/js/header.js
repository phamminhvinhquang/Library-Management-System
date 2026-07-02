document.addEventListener("DOMContentLoaded", () => {
  // 1. ĐIỀU KHIỂN ĐÓNG/MỞ MENU THỂ LOẠI
  const categoryDropdown = document.getElementById("categoryDropdown");
  const categoryMenu = document.getElementById("categoryMenu");

  if (categoryDropdown && categoryMenu) {
    categoryDropdown.addEventListener("click", (e) => {
      e.preventDefault();
      const isHidden =
        categoryMenu.style.display === "none" ||
        categoryMenu.style.display === "";
      categoryMenu.style.display = isHidden ? "block" : "none";
    });

    document.addEventListener("click", (e) => {
      if (!categoryDropdown.contains(e.target)) {
        categoryMenu.style.display = "none";
      }
    });
  }

  // 2. ĐIỀU KHIỂN TÌM KIẾM
  const searchToggle = document.getElementById("searchToggle");
  const searchInput = document.getElementById("searchInput");

  if (searchToggle && searchInput) {
    searchToggle.addEventListener("click", (e) => {
      e.preventDefault();
      searchInput.classList.toggle("active");
      if (searchInput.classList.contains("active")) searchInput.focus();
    });
  }

  // 3. ĐIỀU KHIỂN USER DROPDOWN (Đã được bổ sung logic do bản gốc khai báo nhưng không dùng)
  const menuToggle = document.getElementById("menuToggle");
  const userDropdown = document.getElementById("userDropdown");

  if (menuToggle && userDropdown) {
    menuToggle.addEventListener("click", (e) => {
      e.preventDefault();
      userDropdown.classList.toggle("show");
    });

    document.addEventListener("click", (e) => {
      if (!menuToggle.contains(e.target) && !userDropdown.contains(e.target)) {
        userDropdown.classList.remove("show");
      }
    });
  }
});
