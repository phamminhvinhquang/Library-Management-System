document.addEventListener("DOMContentLoaded", () => {
  let allBooks = []; // Mảng lưu trữ toàn bộ sách để lọc mà không cần gọi lại API

  // Hàm chuyển đổi tiếng Việt có dấu thành không dấu (Hỗ trợ tìm kiếm)
  function removeVietnameseTones(str) {
    if (!str) return "";
    return str
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .replace(/đ/g, "d")
      .replace(/Đ/g, "D")
      .toLowerCase();
  }

  // ==========================================
  // 1. LỌC TÌM KIẾM & ĐÓNG/MỞ SIDEBAR
  // ==========================================
  const searchInput = document.getElementById("searchInput");
  const authorFilterHeader = document.getElementById("authorFilterHeader");
  const sidebarAuthorList = document.getElementById("sidebarAuthorList");
  const authorToggleIcon = document.getElementById("authorToggleIcon");
  const categoryFilterHeader = document.getElementById("categoryFilterHeader");
  const sidebarCategoryList = document.getElementById("sidebarCategoryList");
  const categoryToggleIcon = document.getElementById("categoryToggleIcon");

  if (authorFilterHeader && sidebarAuthorList) {
    authorFilterHeader.addEventListener("click", () => {
      const isHidden = sidebarAuthorList.style.display === "none";
      sidebarAuthorList.style.display = isHidden ? "block" : "none";
      if (authorToggleIcon)
        authorToggleIcon.style.transform = isHidden
          ? "rotate(180deg)"
          : "rotate(0deg)";
    });
  }

  if (categoryFilterHeader && sidebarCategoryList) {
    categoryFilterHeader.addEventListener("click", () => {
      const isHidden = sidebarCategoryList.style.display === "none";
      sidebarCategoryList.style.display = isHidden ? "block" : "none";
      if (categoryToggleIcon)
        categoryToggleIcon.style.transform = isHidden
          ? "rotate(180deg)"
          : "rotate(0deg)";
    });
  }

  if (searchInput) {
    searchInput.addEventListener("input", (e) => {
      const keyword = removeVietnameseTones(e.target.value);
      const filteredBooks = allBooks.filter((book) =>
        removeVietnameseTones(book.bookName).includes(keyword),
      );
      renderBooks(filteredBooks);
    });
  }

  // ==========================================
  // 2. KẾT NỐI API VÀ ĐỔ DỮ LIỆU ĐỘNG
  // ==========================================
  const API_URL = "http://localhost:8086/api/book/books";
  const booksGrid = document.getElementById("booksGrid");

  if (booksGrid) {
    fetch(API_URL)
      .then((response) => response.json())
      .then((books) => {
        allBooks = books;
        renderBooks(allBooks);
        renderCategories(allBooks);
        renderAuthors(allBooks);
        renderTopBorrowedSidebar(allBooks);
      })
      .catch((error) => console.error("Lỗi:", error));
  }

  // ==========================================
  // 3. CÁC HÀM HIỂN THỊ DỮ LIỆU (RENDER)
  // ==========================================
  function renderBooks(booksToRender) {
    const booksGrid = document.getElementById("booksGrid");
    const newBooksGrid = document.getElementById("newBooksGrid");

    if (booksGrid) booksGrid.innerHTML = "";
    if (newBooksGrid) newBooksGrid.innerHTML = "";

    if (!booksToRender || booksToRender.length === 0) {
      if (booksGrid) {
        booksGrid.innerHTML =
          "<p style='padding:20px;'>Không tìm thấy sách phù hợp.</p>";
      }
      return;
    }

    const generateCardHtml = (book) => {
      const authorNames =
        book.authors && book.authors.length > 0
          ? book.authors.map((a) => a.authorName).join(", ")
          : "Chưa rõ tác giả";

      const cateName = book.category
        ? book.category.cateName
        : "Chưa phân loại";

      let coverUrl = "";
      if (book.coverImage) {
        if (book.coverImage.startsWith("http")) {
          coverUrl = book.coverImage;
        } else {
          coverUrl = "http://localhost:8086" + book.coverImage;
        }
      }

      return `
        <div class="book-card" data-id="${book.bookID}">
          <div class="card-img-wrapper">
            <img src="${coverUrl}" alt="${book.bookName}" />
          </div>
          <div class="card-body">
            <h4 class="card-title" title="${book.bookName}">${book.bookName}</h4>
            <p class="card-author">Tác giả: ${authorNames}</p>
            <p class="card-category">Thể loại: ${cateName}</p>

            <div class="book-borrow-count">
              <iconify-icon icon="solar:reorder-linear" style="font-size: 14px;"></iconify-icon> 
              Số lần mượn: ${book.borrowCount || 0} lượt
            </div>
            
            <div class="card-actions">
              <button class="btn-borrow" onclick="alert('Đã thêm yêu cầu mượn: ${book.bookName}')">
                <iconify-icon icon="solar:cart-large-minimalistic-linear"></iconify-icon> Mượn sách
              </button>
              <a href="book_detail.html?id=${book.bookID}" class="btn-detail">Xem chi tiết</a>
            </div>
          </div>
        </div>
      `;
    };

    if (booksGrid) {
      const mostBorrowedBooks = [...booksToRender].sort(
        (a, b) => (b.borrowCount || 0) - (a.borrowCount || 0),
      );
      mostBorrowedBooks.forEach((book) => {
        booksGrid.insertAdjacentHTML("beforeend", generateCardHtml(book));
      });
    }

    if (newBooksGrid) {
      const newestBooks = [...booksToRender]
        .sort((a, b) => (b.bookID || 0) - (a.bookID || 0))
        .slice(0, 4);

      newestBooks.forEach((book) => {
        newBooksGrid.insertAdjacentHTML("beforeend", generateCardHtml(book));
      });
    }

    initSliderScroll();
  }

  function renderCategories(booksData) {
    const categoryMenu = document.getElementById("categoryMenu");
    const sidebarCategoryList = document.getElementById("sidebarCategoryList");
    const categoryMap = new Map();

    booksData.forEach((book) => {
      if (book.category) {
        categoryMap.set(book.category.cateID, book.category.cateName);
      }
    });

    if (categoryMenu) {
      categoryMenu.innerHTML = "";
      const allLi = document.createElement("li");
      allLi.textContent = "Hiển thị tất cả";
      allLi.style.fontWeight = "bold";
      allLi.addEventListener("click", () => renderBooks(allBooks));
      categoryMenu.appendChild(allLi);
    }

    if (sidebarCategoryList) {
      sidebarCategoryList.innerHTML = "";
      const allLiSidebar = document.createElement("li");
      allLiSidebar.innerHTML = `<a href="#" style="font-weight: bold; color: #eab389;">Tất cả thể loại</a>`;
      allLiSidebar.addEventListener("click", (e) => {
        e.preventDefault();
        renderBooks(allBooks);
      });
      sidebarCategoryList.appendChild(allLiSidebar);
    }

    categoryMap.forEach((cateName, cateID) => {
      if (categoryMenu) {
        const li = document.createElement("li");
        li.textContent = cateName;
        li.addEventListener("click", () => {
          const filtered = allBooks.filter(
            (b) => b.category && b.category.cateID === cateID,
          );
          renderBooks(filtered);
        });
        categoryMenu.appendChild(li);
      }

      if (sidebarCategoryList) {
        const liSidebar = document.createElement("li");
        liSidebar.innerHTML = `<a href="#">${cateName}</a>`;
        liSidebar.addEventListener("click", (e) => {
          e.preventDefault();
          const filtered = allBooks.filter(
            (b) => b.category && b.category.cateID === cateID,
          );
          renderBooks(filtered);
        });
        sidebarCategoryList.appendChild(liSidebar);
      }
    });
  }

  function renderAuthors(booksData) {
    const authorMenu = document.getElementById("authorMenu");
    const sidebarAuthorList = document.getElementById("sidebarAuthorList");
    const authorMap = new Map();

    booksData.forEach((book) => {
      if (book.authors && book.authors.length > 0) {
        book.authors.forEach((author) => {
          authorMap.set(author.authorID, author.authorName);
        });
      }
    });

    if (authorMenu) {
      authorMenu.innerHTML = "";
      const allLi = document.createElement("li");
      allLi.textContent = "Hiển thị tất cả";
      allLi.style.fontWeight = "bold";
      allLi.addEventListener("click", () => renderBooks(allBooks));
      authorMenu.appendChild(allLi);
    }

    if (sidebarAuthorList) {
      sidebarAuthorList.innerHTML = "";
      const allLiSidebar = document.createElement("li");
      allLiSidebar.innerHTML = `<a href="#" style="font-weight: bold; color: #eab389;">Tất cả tác giả</a>`;
      allLiSidebar.addEventListener("click", (e) => {
        e.preventDefault();
        renderBooks(allBooks);
      });
      sidebarAuthorList.appendChild(allLiSidebar);
    }

    authorMap.forEach((authorName, authorID) => {
      if (authorMenu) {
        const li = document.createElement("li");
        li.textContent = authorName;
        li.addEventListener("click", () => {
          const filtered = allBooks.filter(
            (b) => b.authors && b.authors.some((a) => a.authorID === authorID),
          );
          renderBooks(filtered);
        });
        authorMenu.appendChild(li);
      }

      if (sidebarAuthorList) {
        const liSidebar = document.createElement("li");
        liSidebar.innerHTML = `<a href="#">${authorName}</a>`;
        liSidebar.addEventListener("click", (e) => {
          e.preventDefault();
          const filtered = allBooks.filter(
            (b) => b.authors && b.authors.some((a) => a.authorID === authorID),
          );
          renderBooks(filtered);
        });
        sidebarAuthorList.appendChild(liSidebar);
      }
    });
  }

  function renderTopBorrowedSidebar(books) {
    const sidebarMostBorrowedList = document.getElementById(
      "sidebarMostBorrowedList",
    );
    if (!sidebarMostBorrowedList) return;

    const topThree = [...books]
      .sort((a, b) => (b.borrowCount || 0) - (a.borrowCount || 0))
      .slice(0, 3);

    sidebarMostBorrowedList.innerHTML = topThree
      .map(
        (book, index) => `
      <li>
        <div class="rank-number rank-${index + 1}">${index + 1}</div>
        <div class="book-info">
          <span class="book-title" title="${book.bookName}">${book.bookName}</span>
          <span class="borrow-count">
            <iconify-icon icon="solar:record-circle-linear" style="font-size: 12px;"></iconify-icon> 
            ${book.borrowCount || 0} lượt
          </span>
        </div>
      </li>
    `,
      )
      .join("");
  }

  // ==========================================
  // 4. HỆ THỐNG TRƯỢT SLIDER SÁCH
  // ==========================================
  function initSliderScroll() {
    const container = document.querySelector(".books-slider-container");
    const btnPrev = document.getElementById("slidePrev");
    const btnNext = document.getElementById("slideNext");

    if (btnPrev) {
      const newBtnPrev = btnPrev.cloneNode(true);
      btnPrev.parentNode.replaceChild(newBtnPrev, btnPrev);
    }
    if (btnNext) {
      const newBtnNext = btnNext.cloneNode(true);
      btnNext.parentNode.replaceChild(newBtnNext, btnNext);
    }

    const currentBtnPrev = document.getElementById("slidePrev");
    const currentBtnNext = document.getElementById("slideNext");

    if (container && currentBtnPrev && currentBtnNext) {
      const getScrollStep = () => {
        const firstCard = container.querySelector(".book-card");
        return firstCard ? firstCard.offsetWidth + 24 : 320;
      };

      currentBtnNext.addEventListener("click", () => {
        container.scrollLeft += getScrollStep();
      });

      currentBtnPrev.addEventListener("click", () => {
        container.scrollLeft -= getScrollStep();
      });
    }
  }
});
