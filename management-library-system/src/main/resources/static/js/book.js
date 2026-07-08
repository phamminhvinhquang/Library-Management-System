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
  const LOAN_API_URL = "http://localhost:8086/api/loan/my-loans";
  const booksGrid = document.getElementById("booksGrid");
  const token = localStorage.getItem("libraryToken");

  if (booksGrid) {
    // Gọi API lấy sách
    fetch(API_URL)
      .then((response) => response.json())
      .then((books) => {
        allBooks = books;

        // Sau khi có sách, tiếp tục gọi API lấy danh sách phiếu mượn (nếu đã đăng nhập)
        if (token) {
          return fetch(LOAN_API_URL, {
            headers: { Authorization: `Bearer ${token}` },
          })
            .then((res) => (res.ok ? res.json() : []))
            .catch(() => []); // Bỏ qua nếu lỗi
        }
        return []; // Nếu chưa đăng nhập thì trả về mảng rỗng
      })
      .then((myLoans) => {
        // Đã có cả Sách và Trạng thái phiếu mượn thật từ DB
        renderBooks(allBooks, myLoans);
        renderCategories(allBooks);
        renderAuthors(allBooks);
        renderTopBorrowedSidebar(allBooks);
      })
      .catch((error) => console.error("Lỗi API:", error));
  }

  // ==========================================
  // 3. CÁC HÀM HIỂN THỊ DỮ LIỆU (RENDER)
  // ==========================================
  function renderBooks(booksToRender, myLoans = []) {
    const booksGrid = document.getElementById("booksGrid");
    const newBooksGrid = document.getElementById("newBooksGrid");

    if (booksGrid) booksGrid.innerHTML = "";
    if (newBooksGrid) newBooksGrid.innerHTML = "";

    if (!booksToRender || booksToRender.length === 0) {
      if (booksGrid)
        booksGrid.innerHTML =
          "<p style='padding:20px;'>Không tìm thấy sách phù hợp.</p>";
      return;
    }

    let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];

    // Tạo bản đồ tra cứu nhanh trạng thái sách từ API Backend
    const bookStatusMap = {};
    myLoans.forEach((ticket) => {
      if (ticket.book && ticket.book.bookID) {
        // Ánh xạ ID sách với trạng thái thật của nó
        bookStatusMap[ticket.book.bookID.toString()] = ticket.status;
      }
    });

    const generateCardHtml = (book) => {
      const bookIdStr = book.bookID ? book.bookID.toString() : "";
      const authorNames =
        book.authors && book.authors.length > 0
          ? book.authors.map((a) => a.authorName).join(", ")
          : "Chưa rõ tác giả";
      const cateName = book.category
        ? book.category.cateName
        : "Chưa phân loại";

      let coverUrl = "images/default-book.png";
      if (book.coverImage) {
        if (
          book.coverImage.startsWith("data:image") ||
          book.coverImage.startsWith("http")
        ) {
          coverUrl = book.coverImage;
        } else {
          coverUrl = "http://localhost:8086" + book.coverImage;
        }
      }

      const currentStatus = bookStatusMap[bookIdStr];
      const isInCart = cart.some(
        (item) => item.id && item.id.toString() === bookIdStr,
      );

      let buttonHtml = "";

      if (book.quantity <= 0) {
        buttonHtml = `
          <button class="btn-borrow disabled" style="background-color: #ff4d4f; color: #fff; cursor: not-allowed;" disabled>
            <iconify-icon icon="solar:close-circle-linear"></iconify-icon> Hết sách
          </button>
        `;
      } else if (
        currentStatus === "Chờ Duyệt" ||
        currentStatus === "Đang Mượn"
      ) {
        const icon =
          currentStatus === "Chờ Duyệt"
            ? "solar:clock-circle-linear"
            : "solar:check-circle-linear";
        buttonHtml = `
            <button class="btn-borrow disabled" style="background-color: #ccc; color: #666; cursor: not-allowed;" disabled>
              <iconify-icon icon="${icon}"></iconify-icon> ${currentStatus}
            </button>
          `;
      } else if (isInCart) {
        buttonHtml = `
          <button class="btn-borrow disabled" style="background-color: #e0e0e0; color: #888; cursor: not-allowed;" disabled>
            <iconify-icon icon="solar:cart-large-linear"></iconify-icon> Trong giỏ
          </button>
        `;
      } else {
        buttonHtml = `
          <button class="btn-borrow" data-id="${book.bookID}" data-title="${book.bookName}" data-image="${coverUrl}" data-author="${authorNames}">
            <iconify-icon icon="solar:cart-large-minimalistic-linear"></iconify-icon> Mượn sách
          </button>
        `;
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
            <div class="book-borrow-count" style="margin-bottom: 4px;">
              <iconify-icon icon="solar:box-minimalistic-linear" style="font-size: 14px;"></iconify-icon> 
              Số lượng: <span style="color: ${book.quantity > 0 ? "#0d0d0d" : "#dc3545"};">${book.quantity || 0}</span> cuốn
            </div>
            <div class="book-borrow-count">
              <iconify-icon icon="solar:reorder-linear" style="font-size: 14px;"></iconify-icon> 
              Số lần mượn: ${book.borrowCount || 0} lượt
            </div>
            <div class="card-actions">
              ${buttonHtml}
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
      mostBorrowedBooks.forEach((book) =>
        booksGrid.insertAdjacentHTML("beforeend", generateCardHtml(book)),
      );
    }

    if (newBooksGrid) {
      const newestBooks = [...booksToRender]
        .sort((a, b) => (b.bookID || 0) - (a.bookID || 0))
        .slice(0, 4);
      newestBooks.forEach((book) =>
        newBooksGrid.insertAdjacentHTML("beforeend", generateCardHtml(book)),
      );
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

  // ==========================================
  // 4. HÀM XỬ LÝ CLICK MƯỢN SÁCH CHUẨN
  // ==========================================
  function handleBorrowClick(event) {
    const borrowBtn = event.target.closest(".btn-borrow");
    if (!borrowBtn) return;

    event.preventDefault();

    const bookId = borrowBtn.getAttribute("data-id");
    const bookTitle =
      borrowBtn.getAttribute("data-title") || "Sách chưa rõ tên";
    const bookImage =
      borrowBtn.getAttribute("data-image") || "images/default-book.png";
    const bookAuthor =
      borrowBtn.getAttribute("data-author") || "Chưa rõ tác giả";

    // KIỂM TRA ĐIỀU KIỆN PHIẾU QUA FILE TICKET.JS
    if (
      window.TicketManager &&
      window.TicketManager.isBookPendingToday(bookId)
    ) {
      alert(
        `Sách không được duyệt xin vui lòng mượn lại!\n\nCuốn "${bookTitle}" đang có phiếu ở trạng thái "Chờ Duyệt" trong ngày hôm nay.`,
      );
      return;
    }

    let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
    const existingBook = cart.find(
      (item) => item.id && item.id.toString() === bookId.toString(),
    );

    if (existingBook) {
      alert(`Cuốn sách "${bookTitle}" đã có sẵn trong giỏ chờ mượn.`);
      return;
    } else {
      cart.push({
        id: bookId,
        title: bookTitle,
        image: bookImage,
        author: bookAuthor,
        quantity: 1,
      });

      localStorage.setItem("libraryCart", JSON.stringify(cart));
      updateCartBadge();

      borrowBtn.classList.add("disabled");
      borrowBtn.style.backgroundColor = "#e0e0e0";
      borrowBtn.style.color = "#888";
      borrowBtn.style.cursor = "not-allowed";
      borrowBtn.setAttribute("disabled", "true");
      borrowBtn.innerHTML = `<iconify-icon icon="solar:cart-large-linear"></iconify-icon> Trong giỏ`;

      alert(`Đã thêm cuốn "${bookTitle}" vào giỏ sách chờ mượn thành công!`);
    }
  }

  if (booksGrid) booksGrid.addEventListener("click", handleBorrowClick);
  const newBooksGrid = document.getElementById("newBooksGrid");
  if (newBooksGrid) newBooksGrid.addEventListener("click", handleBorrowClick);

  function updateCartBadge() {
    const cartBadge = document.getElementById("cartBadge");
    if (cartBadge) {
      let cart = JSON.parse(localStorage.getItem("libraryCart")) || [];
      const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);
      cartBadge.textContent = totalItems;
    }
  }

  updateCartBadge();
});
