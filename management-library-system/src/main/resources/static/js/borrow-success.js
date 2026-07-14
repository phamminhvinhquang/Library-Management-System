/**
 * borrow-success.js
 */

// Hàm lấy ngày hôm nay định dạng DD/MM/YYYY
function getFormattedToday() {
    const today = new Date();
    return `${String(today.getDate()).padStart(2, '0')}/${String(today.getMonth() + 1).padStart(2, '0')}/${today.getFullYear()}`;
}

// Hàm kiểm tra xem một mã sách (bookId) có đang nằm trong phiếu mượn chờ duyệt nào của ngày hôm nay không
function isBookPendingToday(bookId) {
    const formattedToday = getFormattedToday();
    // Lấy danh sách phiếu mượn từ localStorage
    const currentTickets = JSON.parse(localStorage.getItem("myTickets")) || [];

    // Kiểm tra xem có phiếu nào thỏa mãn: trùng ngày, trạng thái Chờ Duyệt và có chứa ID sách cần tìm
    return currentTickets.some(ticket => 
        ticket.borrowDate === formattedToday && 
        ticket.status === "Chờ Duyệt" && 
        ticket.bookIds && 
        ticket.bookIds.includes(bookId)
    );
}

// Xuất các hàm ra phạm vi toàn cục (window) để các file js khác gọi được
window.TicketManager = {
    getFormattedToday: getFormattedToday,
    isBookPendingToday: isBookPendingToday
};

// =======================================================
// XỬ LÝ GIAO DIỆN KHI TRANG ĐƯỢC TẢI
// =======================================================
document.addEventListener("DOMContentLoaded", () => {
    // Dọn sạch giỏ sách tạm cũ
    localStorage.removeItem("libraryCart");

    // 1. TẠO GIAO DIỆN MODAL XEM CHI TIẾT SÁCH
    const viewModalHTML = `
    <div id="loanBookModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:9999; align-items:center; justify-content:center;">
        <div style="background:#fff; padding:30px; border-radius:12px; width:700px; max-width:90%; border: 2px solid #2196f3; display: flex; gap: 20px;">
            <div style="flex: 0 0 160px;">
                <img id="modalLoanBookCover" src="" style="width: 100%; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);" alt="Cover">
            </div>
            <div style="flex: 1; display: flex; flex-direction: column;">
                <div style="display:flex; justify-content: space-between; align-items: flex-start; margin-bottom:15px;">
                    <h3 id="modalLoanBookTitle" style="margin:0; color:#2c3e50; font-size:22px; font-weight:700;"></h3>
                    <span id="modalLoanStatus" style="font-size: 13px; padding: 4px 12px; border-radius: 4px; font-weight: bold; color: #fff; white-space: nowrap;"></span>
                </div>
                <div id="modalLoanBookContent" style="font-size:14.5px; line-height:1.6; color:#34495e; flex: 1; overflow-y: auto; max-height: 300px; margin-bottom: 15px;"></div>
                <div style="text-align:right; margin-top: auto;">
                    <button onclick="closeLoanModal()" style="padding:10px 24px; border:none; background:#7f8c8d; color:#fff; border-radius:6px; cursor:pointer; font-weight: 600;">Đóng Lại</button>
                </div>
            </div>
        </div>
    </div>`;
    document.body.insertAdjacentHTML("beforeend", viewModalHTML);

    // 2. HÀM ĐÓNG MỞ MODAL & FETCH DATA API
    window.closeLoanModal = function () {
      document.getElementById("loanBookModal").style.display = "none";
    };

    window.viewLoanDetail = function (bookId, statusLabel) {
      if (!bookId) {
        alert("Lỗi: Không tìm thấy ID sách!");
        return;
      }

      // Gọi API tương đối (sửa lỗi CORS và hardcode IP)
      fetch(`/api/book/${bookId}`)
        .then((res) => {
           if(!res.ok) throw new Error("Mạng bị lỗi hoặc không tìm thấy sách");
           return res.json();
         })
        .then((book) => {
          let coverUrl = "images/default-book.png";
          if (book.coverImage) {
            coverUrl = book.coverImage; 
          }

          document.getElementById("modalLoanBookCover").src = coverUrl;
          document.getElementById("modalLoanBookTitle").innerText = book.bookName;

          const statusBadge = document.getElementById("modalLoanStatus");
          statusBadge.innerText = statusLabel;
          if (statusLabel === "Chờ Duyệt") statusBadge.style.backgroundColor = "#ff9800";
          else if (statusLabel === "Đang Mượn") statusBadge.style.backgroundColor = "#2196f3";
          else if (statusLabel === "Từ Chối") statusBadge.style.backgroundColor = "#f44336";
          else if (statusLabel === "Đã Trả") statusBadge.style.backgroundColor = "#4caf50";

          let detailHtml = book.bookDetail
            ? book.bookDetail.replace(/\\n/g, "<br>").replace(/\n/g, "<br>")
            : "<i>Chưa có thông tin mô tả chi tiết.</i>";

          document.getElementById("modalLoanBookContent").innerHTML = `
              <p style="margin-bottom: 8px;"><strong>Nhà xuất bản:</strong> ${book.publisher || "N/A"}</p>
              <p style="margin-bottom: 8px;"><strong>Năm xuất bản:</strong> ${book.yearPublish || "N/A"}</p>
              <p style="margin-bottom: 15px;"><strong>Thể loại:</strong> ${book.category ? book.category.cateName : "N/A"}</p>
              <div><strong>Mô tả nội dung:</strong></div>
              <div style="margin-top: 5px; padding: 12px; background: #f8f9fa; border-radius: 6px; border: 1px solid #e9ecef; text-align: justify;">${detailHtml}</div>
          `;

          document.getElementById("loanBookModal").style.display = "flex";
        })
        .catch((err) => {
          console.error(err);
          alert("Không thể tải thông tin chi tiết sách từ máy chủ!");
        });
    };

    // 3. RENDER BẢNG PHIẾU MƯỢN TỪ API
    const tableBody = document.getElementById("ticketTableBody");
    const token = localStorage.getItem("libraryToken");

    if (!token) {
      tableBody.innerHTML = `<tr><td colspan="6" style="padding: 30px; color: red; text-align:center;">Vui lòng đăng nhập để xem phiếu mượn của bạn!</td></tr>`;
      return;
    }

    // Gọi API tương đối (sửa lỗi 404)
    fetch("/api/loan/my-loans", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then(async (res) => {
            if (!res.ok) {
                const text = await res.text();
                console.log("Status:", res.status);
                console.log(text);
                throw new Error(text);
            }
            return res.json();
        })
      .then((myDetails) => {
        tableBody.innerHTML = "";

        if (myDetails && myDetails.length > 0) {
          myDetails.forEach((detail) => {
            let statusClass = "status-pending";
            if (detail.status === "Đang Mượn") statusClass = "status-approved";
            else if (detail.status === "Từ Chối") statusClass = "status-rejected";
            else if (detail.status === "Đã Trả") statusClass = "status-returned";

            const mainCardId = detail.loanCard ? detail.loanCard.cardID : detail.detailID;
            const bookId = detail.book ? detail.book.bookID : null;

            const rowHTML = `
                    <tr>
                        <td><strong>PM-${mainCardId}-${detail.detailID}</strong></td>
                        <td>${detail.borrowDate}</td>
                        <td>${detail.dueDate}</td>
                        <td><span class="badge-book-count">1</span></td>
                        <td><span class="badge-status ${statusClass}">${detail.status}</span></td>
                        <td>
                            <button class="btn-action-view" onclick="viewLoanDetail(${bookId}, '${detail.status}')">
                                <iconify-icon icon="solar:eye-linear"></iconify-icon> Xem
                            </button>
                        </td>
                    </tr>
                `;
            tableBody.insertAdjacentHTML("beforeend", rowHTML);
          });
        } else {
          tableBody.innerHTML = `<tr><td colspan="6" style="padding: 30px; color: #888;">Bạn chưa gửi yêu cầu mượn sách nào.</td></tr>`;
        }
      })
      .catch((err) => {
        console.error("Lỗi:", err);
        tableBody.innerHTML = `<tr><td colspan="6" style="padding: 30px; color: red;">Không thể tải dữ liệu phiếu mượn từ cơ sở dữ liệu!</td></tr>`;
      });
});