document.addEventListener("DOMContentLoaded", () => {
  // 1. Lấy tham số 'id' từ URL
  const urlParams = new URLSearchParams(window.location.search);
  const bookId = urlParams.get("id");

  if (!bookId) {
    alert("Không tìm thấy mã sách hợp lệ!");
    window.location.href = "index.html";
    return;
  }

  const API_URL = `http://3.235.63.103:8086/api/book/${bookId}`;

  // Hàm cập nhật số lượng hiển thị trên Badge giỏ hàng
  function updateCartBadge() {
    const cartBadge = document.getElementById("cartBadge");
    if (cartBadge) {
      let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
      const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);
      cartBadge.textContent = totalItems;
    }
  }

  // Hàm vô hiệu hóa nút khi sách đã nằm trong giỏ
  function setDisabledButton(button) {
    button.classList.add("disabled");
    button.style.backgroundColor = "#ccc";
    button.style.color = "#666";
    button.style.cursor = "not-allowed";
    button.setAttribute("disabled", "true");
    button.innerHTML = `<iconify-icon icon="solar:check-circle-linear"></iconify-icon> <span>Đã chọn mượn</span>`;
  }

  // 2. Gọi API để lấy dữ liệu chi tiết sách
  fetch(API_URL)
    .then((response) => {
      if (!response.ok) throw new Error("Không thể lấy thông tin sách");
      return response.json();
    })
    .then((book) => {
      // Đổ dữ liệu nhận được vào HTML
      document.getElementById("bookTitle").textContent = book.bookName;

      // Xử lý hình ảnh bìa sách
      let coverUrl = "images/default-book.png";

      if (book.coverImage) {
        if (
          book.coverImage.startsWith("data:image") ||
          book.coverImage.startsWith("http")
        ) {
          coverUrl = book.coverImage;
        } else {
          coverUrl = "http://3.235.63.103:8086" + book.coverImage;
        }
      }
      document.getElementById("bookCover").src = coverUrl;

      document.getElementById("bookPublisher").textContent = book.publisher;
      document.getElementById("bookYear").textContent = book.yearPublish;
      document.getElementById("bookQuantity").textContent = book.quantity;
      document.getElementById("bookBorrowCount").textContent =
        book.borrowCount || 0;

      // Xử lý text mô tả chi tiết
      document.getElementById("bookDetail").textContent =
        book.bookDetail || "Chưa có mô tả chi tiết cho cuốn sách này.";

      // Lấy tên thể loại
      if (book.category) {
        document.getElementById("bookCategory").textContent =
          book.category.cateName;
      }

      // Lấy tên các tác giả
      let authorNames = "Chưa rõ tác giả";
      if (book.authors && book.authors.length > 0) {
        authorNames = book.authors
          .map((author) => author.authorName)
          .join(", ");
      }
      document.getElementById("bookAuthors").textContent = authorNames;

      // ==========================================
      // TÍCH HỢP XỬ LÝ NÚT MƯỢN SÁCH CHI TIẾT
      // ==========================================
      const detailBorrowBtn = document.getElementById("detailBorrowBtn");
      if (detailBorrowBtn) {
        // Gán ngược dữ liệu mềm vào các thuộc tính data để phục vụ hàm Click
        detailBorrowBtn.setAttribute("data-id", book.bookID);
        detailBorrowBtn.setAttribute("data-title", book.bookName);
        detailBorrowBtn.setAttribute("data-image", coverUrl);
        detailBorrowBtn.setAttribute("data-author", authorNames);

        // Kiểm tra xem sách hiện tại đã có trong giỏ hàng LocalStorage chưa
        let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
        const isInCart = cart.some(
          (item) => item.id && item.id.toString() === book.bookID.toString(),
        );

        if (isInCart) {
          setDisabledButton(detailBorrowBtn);
        }

        // Đăng ký sự kiện Click mượn sách
        detailBorrowBtn.addEventListener("click", (e) => {
          e.preventDefault();

          let currentCart =
            JSON.parse(localStorage.getItem("libraryCart")) || [];
          const existingBook = currentCart.find(
            (item) => item.id && item.id.toString() === book.bookID.toString(),
          );

          if (existingBook) {
            alert(`Cuốn sách "${book.bookName}" đã có sẵn trong giỏ chờ mượn.`);
            return;
          } else {
            // Đẩy cấu trúc đối tượng đồng bộ hoàn toàn với file book.js cũ của bạn
            currentCart.push({
              id: book.bookID.toString(),
              title: book.bookName,
              image: coverUrl,
              author: authorNames,
              quantity: 1,
            });

            localStorage.setItem("libraryCart", JSON.stringify(currentCart));
            updateCartBadge();
            setDisabledButton(detailBorrowBtn);

            alert(
              `Đã thêm cuốn "${book.bookName}" vào giỏ sách chờ mượn thành công!`,
            );
          }
        });
      }
    })
    .catch((error) => {
      console.error("Lỗi:", error);
      document.getElementById("bookTitle").textContent =
        "Lỗi tải dữ liệu sách!";
    });

  // Chạy cập nhật badge hiển thị số lượng giỏ hàng ngay khi vừa load trang chi tiết
  updateCartBadge();
});
