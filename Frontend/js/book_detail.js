document.addEventListener("DOMContentLoaded", () => {
  // 1. Lấy tham số 'id' từ URL
  const urlParams = new URLSearchParams(window.location.search);
  const bookId = urlParams.get("id");

  if (!bookId) {
    alert("Không tìm thấy mã sách hợp lệ!");
    window.location.href = "book.html";
    return;
  }

  // 2. SỬA LỖI PORT TẠI ĐÂY: Đổi 8080 thành 8086 cho khớp với backend
  const API_URL = `http://localhost:8086/api/book/${bookId}`;

  fetch(API_URL)
    .then((response) => {
      if (!response.ok) throw new Error("Không thể lấy thông tin sách");
      return response.json();
    })
    .then((book) => {
      // 3. Đổ dữ liệu nhận được vào HTML
      document.getElementById("bookTitle").textContent = book.bookName;

      // XỬ LÝ HÌNH ẢNH THÔNG MINH (Giống trang book.js)
      let coverUrl = "images/default-cover.jpg"; // Ảnh mặc định
      if (book.coverImage) {
        if (book.coverImage.startsWith("http")) {
          coverUrl = book.coverImage;
        } else {
          coverUrl = "http://localhost:8086" + book.coverImage;
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
      if (book.authors && book.authors.length > 0) {
        const authorNames = book.authors
          .map((author) => author.authorName)
          .join(", ");
        document.getElementById("bookAuthors").textContent = authorNames;
      } else {
        document.getElementById("bookAuthors").textContent = "Đang cập nhật";
      }
    })
    .catch((error) => {
      console.error("Lỗi:", error);
      document.getElementById("bookTitle").textContent =
        "Lỗi tải dữ liệu sách!";
    });
});
