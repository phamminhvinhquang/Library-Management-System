document.addEventListener("DOMContentLoaded", () => {
  let allBooks = [];

  const API_URL = "http://localhost:8086/api/book/books";
  const container = document.getElementById("categorizedBooksContainer");

  if (!container) return;

  fetch(API_URL)
    .then((response) => response.json())
    .then((books) => {
      allBooks = books;
      renderCategorizedBooks(allBooks);
    })
    .catch((error) => {
      console.error("Lỗi khi tải dữ liệu:", error);
      container.innerHTML = `
        <p style="color:red;text-align:center;">
          Lỗi tải dữ liệu. Vui lòng kiểm tra Server!
        </p>
      `;
    });

  function renderCategorizedBooks(booksToRender) {
    container.innerHTML = "";

    if (!booksToRender || booksToRender.length === 0) {
      container.innerHTML =
        "<p style='text-align:center;padding:20px;'>Không tìm thấy sách nào.</p>";
      return;
    }

    const groupedBooks = booksToRender.reduce((acc, book) => {
      const cateName = book.category
        ? book.category.cateName
        : "Chưa phân loại";

      if (!acc[cateName]) {
        acc[cateName] = [];
      }

      acc[cateName].push(book);
      return acc;
    }, {});

    let htmlContent = "";

    for (const [categoryName, categoryBooks] of Object.entries(groupedBooks)) {
      htmlContent += `
        <div class="category-group">
          <h3 class="category-title">
            <iconify-icon
              icon="solar:notebook-bold-duotone"
              style="color:#eab389;">
            </iconify-icon>

            ${categoryName}

            <span class="count">${categoryBooks.length} cuốn</span>
          </h3>

          <div class="books-grid">
      `;

      categoryBooks.forEach((book) => {
        const authorNames =
          book.authors && book.authors.length
            ? book.authors.map((a) => a.authorName).join(", ")
            : "Chưa rõ tác giả";

        let coverUrl =
          "https://images.unsplash.com/photo-1543002588-bfa74002ed7e?w=400";

        if (book.coverImage) {
          coverUrl = book.coverImage.startsWith("http")
            ? book.coverImage
            : "http://localhost:8086" + book.coverImage;
        }

        htmlContent += `
          <div class="book-card" data-id="${book.bookID}">
            <div class="card-img-wrapper">
              <img src="${coverUrl}" alt="${book.bookName}">
            </div>

            <div class="card-body">

              <h4 class="card-title">
                ${book.bookName}
              </h4>

              <p class="card-author">
                ${authorNames}
              </p>

              <div class="book-borrow-count">
                <iconify-icon icon="solar:history-linear"></iconify-icon>
                Đã mượn: ${book.borrowCount || 0} lần
              </div>

              <div class="card-actions">

                <button class="btn-borrow">
                  <iconify-icon
                    icon="solar:cart-large-minimalistic-linear">
                  </iconify-icon>

                  Mượn sách
                </button>

                <button class="btn-detail">
                  Chi tiết
                </button>

              </div>

            </div>

          </div>
        `;
      });

      htmlContent += `
          </div>
        </div>
      `;
    }

    container.innerHTML = htmlContent;
  }
});
