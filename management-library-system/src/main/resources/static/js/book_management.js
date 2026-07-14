// book_management.js
document.addEventListener("DOMContentLoaded", () => {
  const token = localStorage.getItem("libraryToken");
  const userRole = localStorage.getItem("libraryRole");

  if (!token || !userRole || userRole === "ROLE_USER") {
    alert(
      "Truy cập bị từ chối! Chỉ Admin và Nhân viên mới có quyền quản lý sách.",
    );
    window.location.href = "index.html";
    return;
  }

  // 1. Mở Modal Thêm Sách
  const btnAddBook = document.querySelector(".btn-add-book");
  const addBookModal = document.getElementById("addBookModal");

  // Biến lưu trữ ảnh dưới dạng base64 (Chỉ dùng để làm Preview hiển thị tạm trên giao diện)
  let base64CoverImage = "";

  btnAddBook.addEventListener("click", () => {
    addBookModal.style.display = "flex";
  });

  window.closeAddModal = function () {
    addBookModal.style.display = "none";
  };

  // Xử lý chọn ảnh và hiển thị preview (Giữ nguyên của bạn vì UX rất tốt)
  document
    .getElementById("addCoverFile")
    .addEventListener("change", function (e) {
      const file = e.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = function (event) {
          base64CoverImage = event.target.result; // Chuyển sang chuỗi Base64 để preview
          document.getElementById("addCoverPreview").src = base64CoverImage;
          document.getElementById("addCoverPreview").style.display = "block";
        };
        reader.readAsDataURL(file);
      }
    });

  // =========================================================
  // 2. XỬ LÝ LƯU SÁCH MỚI (GỬI LÊN BACKEND SPRING BOOT)
  // =========================================================
  const addBookForm = document.getElementById("addBookForm");
  if (addBookForm) {
    // Đổi function thành async để dùng await cho S3
    addBookForm.addEventListener("submit", async function (e) {
      e.preventDefault();

      // người dùng chọn ảnh
      const token = localStorage.getItem("libraryToken");
      const fileInput = document.getElementById("addCoverFile");
      const selectedFile = fileInput.files[0];
      
      // Mặc định nếu không up ảnh
      let uploadedImageUrl = "images/default-cover.jpg";

      // ---------------------------------------------------------
      // UPLOAD ẢNH LÊN S3
      // ---------------------------------------------------------
      if (selectedFile) {
        const formData = new FormData(); //FormData sẽ chứa file ảnh
        formData.append("file", selectedFile);

        try {
            const uploadRes = await fetch("http://3.235.63.103:8086/api/upload/image", {
                method: "POST",
                headers: {
                    "Authorization": `Bearer ${token}` 
                },
                body: formData
            });
            
            // SỬA LẠI ĐOẠN NÀY: Đọc chi tiết lỗi từ Backend Spring Boot gửi về
            if (!uploadRes.ok) {
                const errorData = await uploadRes.json();
                throw new Error(errorData.message || "Lỗi không xác định từ máy chủ");
            }
            
            const uploadData = await uploadRes.json();
            uploadedImageUrl = uploadData.imageUrl; 
        } catch (err) {
            // Sẽ in ra đích danh lỗi: sai token, sai bucket name, hay Access Denied
            alert(err.message); 
            console.error(err);
            return; 
        }
      }
      // ---------------------------------------------------------
      // KẾT THÚC ĐOẠN ĐÃ ĐƯỢC HOÀN THIỆN
      // ---------------------------------------------------------

      // Gom toàn bộ dữ liệu từ các ô input (bao gồm ô Số lượng, Tác giả và Thể loại)
      const payload = {
        bookName: document.getElementById("addBookName").value,
        authorName: document.getElementById("addAuthor").value, 
        yearPublish: document.getElementById("addYear").value,
        categoryName: document.getElementById("addCategory").value, 
        publisher: document.getElementById("addPublisher").value,
        quantity: document.getElementById("addQuantity").value, 
        bookDetail: document.getElementById("addDetail").value,
        coverImage: uploadedImageUrl, // Đã thay bằng biến chứa link S3
      };

      fetch("http://3.235.63.103:8086/api/book/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(payload),
      })
        .then((response) =>
          response
            .json()
            .then((data) => ({ status: response.status, body: data })),
        )
        .then((res) => {
          if (res.status === 200) {
            alert(res.body.message);
            closeAddModal(); // Đóng modal
            addBookForm.reset(); // Xóa trắng form
            document.getElementById("addCoverPreview").style.display = "none";
            base64CoverImage = ""; // Reset preview
            
            // Clear input file để không bị kẹt file cũ
            document.getElementById("addCoverFile").value = ""; 

            // Gọi lại hàm tải danh sách sách
            if (typeof fetchBooks === "function") {
              fetchBooks();
            } else {
              window.location.reload();
            }
          } else {
            alert(res.body.message || "Có lỗi xảy ra khi thêm sách!");
          }
        })
        .catch((err) => {
          console.error("Lỗi:", err);
          alert("Không thể kết nối đến máy chủ Backend!");
        });
    });
  }

  // =========================================================
  // 3. KHỞI TẠO MODAL XEM CHI TIẾT SÁCH
  // =========================================================
  const viewModalHTML = `
  <div id="bookModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:9999; align-items:center; justify-content:center;">
      <div style="background:#fff; padding:30px; border-radius:12px; width:700px; max-width:90%; border: 2px solid #0084ff; display: flex; gap: 20px;">
          <div style="flex: 0 0 160px;">
              <img id="modalBookCover" src="" style="width: 100%; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);" alt="Cover">
          </div>
          <div style="flex: 1; display: flex; flex-direction: column;">
              <h3 id="modalBookTitle" style="margin-bottom:15px; color:#2c3e50; font-size:22px; font-weight:700;"></h3>
              <div id="modalBookContent" style="font-size:14.5px; line-height:1.6; color:#34495e; flex: 1; overflow-y: auto; max-height: 300px; margin-bottom: 15px;"></div>
              <div style="text-align:right; margin-top: auto;">
                  <button onclick="closeBookModal()" style="padding:10px 24px; border:none; background:#7f8c8d; color:#fff; border-radius:6px; cursor:pointer; font-weight: 600;">Đóng Lại</button>
              </div>
          </div>
      </div>
  </div>`;
  document.body.insertAdjacentHTML("beforeend", viewModalHTML);

  // =========================================================
  // 4. KHỞI TẠO MODAL CHỈNH SỬA SÁCH
  // =========================================================
  const editModalHTML = `
  <div id="editBookModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:9999; align-items:center; justify-content:center;">
      <div style="background:#fff; padding:25px; border-radius:12px; width:500px; max-width:90%; border: 2px solid #ffc107;">
          <h3 style="margin-bottom:20px; color:#2c3e50; text-align:center;">Chỉnh Sửa Thông Tin Sách</h3>
          <form id="editBookForm">
              <input type="hidden" id="editBookId">
              
              <div style="margin-bottom: 12px;">
                  <label style="font-weight:600; font-size:14px;">Mã Sách (Không thể sửa):</label>
                  <input type="text" id="editBookCode" disabled style="width:100%; padding:10px; margin-top:5px; background:#f4f5f7; border:1px solid #ccc; border-radius:6px; cursor:not-allowed;">
              </div>
              
              <div style="margin-bottom: 12px;">
                  <label style="font-weight:600; font-size:14px;">Tiêu Đề Sách:</label>
                  <input type="text" id="editBookName" required style="width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px;">
              </div>
              
              <div style="display: flex; gap: 15px; margin-bottom: 12px;">
                  <div style="flex:1;">
                      <label style="font-weight:600; font-size:14px;">Nhà Xuất Bản:</label>
                      <input type="text" id="editPublisher" required style="width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px;">
                  </div>
                  <div style="flex:1;">
                      <label style="font-weight:600; font-size:14px;">Năm Xuất Bản:</label>
                      <input type="number" id="editYear" required style="width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px;">
                  </div>
              </div>
              
              <div style="margin-bottom: 12px;">
                  <label style="font-weight:600; font-size:14px;">Số Lượng Trong Kho:</label>
                  <input type="number" id="editQuantity" required style="width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px;">
              </div>
              
              <div style="margin-bottom: 20px;">
                  <label style="font-weight:600; font-size:14px;">Mô Tả Chi Tiết:</label>
                  <textarea id="editDetail" rows="4" style="width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px;"></textarea>
              </div>
              
              <div style="text-align:right;">
                  <button type="button" onclick="closeEditModal()" style="padding:10px 20px; border:none; background:#7f8c8d; color:#fff; border-radius:6px; cursor:pointer;">Hủy Bỏ</button>
                  <button type="submit" style="padding:10px 20px; border:none; background:#ffc107; color:#000; font-weight:bold; border-radius:6px; cursor:pointer; margin-left:10px;">Lưu Thay Đổi</button>
              </div>
          </form>
      </div>
  </div>`;
  document.body.insertAdjacentHTML("beforeend", editModalHTML);

  const tableBody = document.getElementById("bookTableBody");
  const searchInput = document.getElementById("searchInput");
  const btnSearch = document.getElementById("btnSearch");

  let allBooks = [];

  // =========================================================
  // GỌI API LẤY DỮ LIỆU TỪ MYSQL
  // =========================================================
  function fetchBooks() {
    fetch("http://3.235.63.103:8086/api/book/books", { method: "GET" })
      .then((response) => response.json())
      .then((data) => {
        allBooks = data;
        renderTable(allBooks);
      })
      .catch((error) => console.error("Lỗi API:", error));
  }

  function renderTable(data) {
    tableBody.innerHTML = "";

    if (data.length === 0) {
      tableBody.innerHTML = `<tr><td colspan="8" style="text-align: center; padding: 20px;">Không tìm thấy sách nào.</td></tr>`;
      return;
    }

    data.forEach((book) => {
      const bookCode = "S" + book.bookID.toString().padStart(3, "0");
      const authorNames =
        book.authors && book.authors.length > 0
          ? book.authors.map((a) => a.authorName).join(", ")
          : "N/A";
      const categoryName = book.category ? book.category.cateName : "N/A";

      const row = `
                <tr>
                    <td><b>${bookCode}</b></td>
                    <td style="max-width: 250px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; font-weight: 600;" title="${book.bookName}">${book.bookName}</td>
                    <td><span class="badge badge-author">${authorNames}</span></td>
                    <td><span class="badge badge-category">${categoryName}</span></td>
                    <td>${book.publisher || "N/A"}</td>
                    <td>${book.yearPublish || "N/A"}</td>
                    <td><span class="badge badge-quantity">${book.quantity || 0}</span></td>
                    <td>
                        <div class="action-buttons">
                            <button class="btn-action btn-view" onclick="viewBookDetail(${book.bookID})" title="Xem chi tiết"><iconify-icon icon="ph:eye-bold"></iconify-icon></button>
                            <button class="btn-action btn-edit" onclick="openEditModal(${book.bookID})" title="Chỉnh sửa"><iconify-icon icon="ph:pencil-simple-bold"></iconify-icon></button>
                            <button class="btn-action btn-delete" onclick="deleteBook(${book.bookID})" title="Xóa"><iconify-icon icon="ph:trash-bold"></iconify-icon></button>
                        </div>
                    </td>
                </tr>
            `;
      tableBody.insertAdjacentHTML("beforeend", row);
    });
  }

  // =========================================================
  // XỬ LÝ MODAL XEM CHI TIẾT
  // =========================================================
  window.closeBookModal = function () {
    document.getElementById("bookModal").style.display = "none";
  };

  window.viewBookDetail = function (id) {
    const book = allBooks.find((b) => b.bookID === id);
    if (!book) return;

    let coverUrl = "images/default-book.png";
    if (book.coverImage) {
      if (
        book.coverImage.startsWith("http") ||
        book.coverImage.startsWith("data:image")
      ) {
        coverUrl = book.coverImage;
      } else {
        coverUrl = "http://3.235.63.103:8086" + book.coverImage;
      }
    }

    document.getElementById("modalBookCover").src = coverUrl;
    document.getElementById("modalBookTitle").innerText = book.bookName;

    let detailHtml = book.bookDetail
      ? book.bookDetail.replace(/\\n/g, "<br>").replace(/\n/g, "<br>")
      : "<i>Chưa có thông tin mô tả chi tiết.</i>";

    document.getElementById("modalBookContent").innerHTML = `
        <p style="margin-bottom: 8px;"><strong>Nhà xuất bản:</strong> ${book.publisher || "N/A"}</p>
        <p style="margin-bottom: 8px;"><strong>Năm xuất bản:</strong> ${book.yearPublish || "N/A"}</p>
        <p style="margin-bottom: 15px;"><strong>Tổng lượt mượn:</strong> ${book.borrowCount || 0} lượt</p>
        <div><strong>Mô tả nội dung (Book Detail):</strong></div>
        <div style="margin-top: 5px; padding: 12px; background: #f8f9fa; border-radius: 6px; border: 1px solid #e9ecef; text-align: justify;">${detailHtml}</div>
      `;
    document.getElementById("bookModal").style.display = "flex";
  };

  // =========================================================
  // XỬ LÝ SỬA THÔNG TIN SÁCH
  // =========================================================
  window.openEditModal = function (id) {
    const book = allBooks.find((b) => b.bookID === id);
    if (!book) return;

    // Đổ dữ liệu cũ vào Form
    document.getElementById("editBookId").value = book.bookID;
    document.getElementById("editBookCode").value =
      "S" + book.bookID.toString().padStart(3, "0");
    document.getElementById("editBookName").value = book.bookName || "";
    document.getElementById("editPublisher").value = book.publisher || "";
    document.getElementById("editYear").value = book.yearPublish || "";
    document.getElementById("editQuantity").value = book.quantity || 0;
    document.getElementById("editDetail").value = book.bookDetail || "";

    document.getElementById("editBookModal").style.display = "flex";
  };

  window.closeEditModal = function () {
    document.getElementById("editBookModal").style.display = "none";
  };

  document
    .getElementById("editBookForm")
    .addEventListener("submit", function (e) {
      e.preventDefault();
      const id = document.getElementById("editBookId").value;

      // Gói dữ liệu mới từ Form
      const updatedData = {
        bookName: document.getElementById("editBookName").value,
        publisher: document.getElementById("editPublisher").value,
        yearPublish: document.getElementById("editYear").value,
        quantity: document.getElementById("editQuantity").value,
        bookDetail: document.getElementById("editDetail").value,
      };

      fetch(`http://3.235.63.103:8086/api/book/${id}`, {
        method: "PUT",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedData),
      })
        .then((res) =>
          res.json().then((data) => ({ status: res.status, body: data })),
        )
        .then((res) => {
          if (res.status === 200) {
            alert(res.body.message);
            closeEditModal();
            fetchBooks(); // Tải lại bảng ngay lập tức
          } else {
            alert(res.body.message || "Lỗi cập nhật sách!");
          }
        });
    });

  // =========================================================
  // XỬ LÝ XÓA SÁCH
  // =========================================================
  window.deleteBook = function (id) {
    if (
      !confirm(
        "⚠️ Bạn có chắc chắn muốn xóa cuốn sách này không? Mọi dữ liệu sẽ bị mất!",
      )
    )
      return;

    fetch(`http://3.235.63.103:8086/api/book/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
      .then((res) =>
        res.json().then((data) => ({ status: res.status, body: data })),
      )
      .then((res) => {
        if (res.status === 200) {
          alert(res.body.message);
          fetchBooks(); // Tải lại bảng sau khi xóa
        } else {
          alert(res.body.message || "Lỗi xóa sách!");
        }
      });
  };

  // =========================================================
  // TÌM KIẾM
  // =========================================================
  function handleSearch() {
    const keyword = removeVietnameseTones(
      searchInput.value.toLowerCase().trim(),
    );
    const results = allBooks.filter((book) => {
      const bookCode = "S" + book.bookID.toString().padStart(3, "0");
      const bName = removeVietnameseTones(book.bookName || "");
      const bPub = removeVietnameseTones(book.publisher || "");
      const bAuthor = removeVietnameseTones(
        book.authors ? book.authors.map((a) => a.authorName).join(" ") : "",
      );
      return (
        bookCode.toLowerCase().includes(keyword) ||
        bName.includes(keyword) ||
        bPub.includes(keyword) ||
        bAuthor.includes(keyword)
      );
    });
    renderTable(results);
  }

  function removeVietnameseTones(str) {
    if (!str) return "";
    return str
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .replace(/đ/g, "d")
      .replace(/Đ/g, "D")
      .toLowerCase();
  }

  btnSearch.addEventListener("click", handleSearch);
  searchInput.addEventListener("keyup", (e) => {
    if (e.key === "Enter") handleSearch();
    if (e.target.value === "") renderTable(allBooks);
  });

  fetchBooks();
});