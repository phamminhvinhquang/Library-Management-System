document.addEventListener("DOMContentLoaded", () => {
  const tbody = document.querySelector(".items-table tbody");

  // ==========================================
  // 1. HÀM HIỂN THỊ DANH SÁCH SÁCH TỪ LOCALSTORAGE
  // ==========================================
  function renderCartItems() {
    if (!tbody) return;

    // Đọc dữ liệu mượn từ key đồng bộ libraryCart
    let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];

    if (cart.length === 0) {
      tbody.innerHTML = `<tr><td colspan="3" style="text-align:center; padding: 30px; color: #888;">Giỏ hàng trống</td></tr>`;
      updateCartCount();
      return;
    }

    tbody.innerHTML = cart
      .map(
        (item) => `
            <tr>
                <td>
                    <div class="book-info-block">
                        <img class="book-cover-img" src="${item.image || "images/default-book.png"}" alt="${item.title}">
                        <div class="book-text">
                            <div class="book-name-title" title="${item.title}">${item.title}</div>
                            <div class="book-code-id">Mã sách: ${item.id}</div>
                        </div>
                    </div>
                </td>
                <td>
                    <span class="author-label">${item.author || "Chưa rõ tác giả"}</span>
                </td>
                <td style="text-align: center;">
                    <button class="action-delete-btn" data-id="${item.id}" title="Xóa khỏi giỏ mượn">
                        <iconify-icon icon="solar:trash-bin-trash-linear"></iconify-icon> Xóa
                    </button>
                </td>
            </tr>
        `,
      )
      .join("");

    updateCartCount();
    setupRemoveEvents();
  }

  // ==========================================
  // 2. TỰ ĐỘNG CẬP NHẬT TỔNG SỐ SÁCH & BADGE
  // ==========================================
  function updateCartCount() {
    let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
    const totalBooks = cart.reduce(
      (sum, item) => sum + (item.quantity || 1),
      0,
    );

    const summaryValue = document.querySelector(".summary-value");
    if (summaryValue) summaryValue.textContent = `${totalBooks} Cuốn`;

    const cartBadge = document.getElementById("cartBadge");
    if (cartBadge) cartBadge.textContent = totalBooks;
  }

  // ==========================================
  // 3. LOGIC XÓA SÁCH KHỎI GIỎ HÀNG CHỜ MƯỢN
  // ==========================================
  function setupRemoveEvents() {
    const removeButtons = document.querySelectorAll(".action-delete-btn");
    removeButtons.forEach((button) => {
      button.addEventListener("click", () => {
        const bookId = button.getAttribute("data-id");
        let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];

        cart = cart.filter(
          (item) => item.id && item.id.toString() !== bookId.toString(),
        );
        localStorage.setItem("libraryCart", JSON.stringify(cart));
        renderCartItems();
      });
    });
  }

  // Xóa toàn bộ giỏ hàng
  const btnClearAll = document.querySelector(".btn-clear-all");
  if (btnClearAll) {
    btnClearAll.addEventListener("click", () => {
      if (confirm("Bạn có chắc chắn muốn xóa tất cả sách khỏi giỏ chờ mượn?")) {
        localStorage.removeItem("libraryCart");
        renderCartItems();
      }
    });
  }

  // ==========================================
  // 4. LOGIC HOÀN TẤT MƯỢN SÁCH (ĐÃ CẬP NHẬT LƯU FULL THÔNG TIN SÁCH)
  // ==========================================
  const btnCompleteBorrow = document.querySelector(".btn-complete-borrow");
  if (btnCompleteBorrow) {
    btnCompleteBorrow.addEventListener("click", () => {
      let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
      const token = localStorage.getItem("libraryToken");

      if (!token) {
        alert("Vui lòng đăng nhập trước khi thực hiện mượn sách!");
        window.location.href = "login.html";
        return;
      }

      if (cart.length === 0) {
        alert("Giỏ sách của bạn đang trống!");
        return;
      }

      const expectedReturnDateVal =
        document.getElementById("expectedReturnDate").value;
      if (!expectedReturnDateVal) {
        alert("Vui lòng chọn Ngày trả dự kiến trước khi hoàn tất!");
        return;
      }

      // Trích xuất danh sách các ID của sách đang chứa trong giỏ hàng
      const bookIdsArray = cart.map((item) => parseInt(item.id));

      const payload = {
        expectedReturnDate: expectedReturnDateVal, // Định dạng chuỗi YYYY-MM-DD
        bookIds: bookIdsArray,
      };

      // Thực hiện gửi dữ liệu lưu vào bảng Loan_Card và Loan_Detail của MySQL
      fetch("http://localhost:8086/api/loan/create", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(payload),
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
          // Xóa sạch giỏ hàng tạm ở local sau khi dữ liệu đã lưu kho DB thành công
          localStorage.removeItem("libraryCart");
          alert(data.message);
          window.location.href = "borrow-success.html";
        })
        .catch((err) => {
          console.error("Lỗi tạo phiếu mượn:", err);
          alert(
            err.message ||
              "Không thể gửi yêu cầu mượn sách lên máy chủ Backend!",
          );
        });
    });
  }

  renderCartItems();
});
