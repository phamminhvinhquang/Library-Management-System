document.addEventListener("DOMContentLoaded", () => {
    // ==========================================
    // 1. TỰ ĐỘNG CẬP NHẬT TỔNG SỐ SÁCH & BADGE
    // ==========================================
    function updateCartCount() {
        // Đếm số hàng (tr) đang có trong tbody của bảng danh sách sách
        const bookRows = document.querySelectorAll(".items-table tbody tr");
        const totalBooks = bookRows.length;

        // 1. Cập nhật số lượng ở khối "Xác Nhận Mượn Sách" bên phải
        const summaryValue = document.querySelector(".summary-value");
        if (summaryValue) {
            summaryValue.textContent = `${totalBooks} Cuốn`;
        }

        // 2. Cập nhật Badge số lượng trên nút giỏ hàng hình tròn (Header)
        const badgeCount = document.querySelector(".cart-borrow-btn .cart-badge") || document.querySelector(".cart-circle-btn .badge-count");
        if (badgeCount) {
            badgeCount.textContent = totalBooks;
        }
        
        // Nếu không còn cuốn sách nào, hiển thị thông báo trống
        const tbody = document.querySelector(".items-table tbody");
        if (totalBooks === 0 && tbody) {
            tbody.innerHTML = `<tr><td colspan="3" style="text-align:center; padding: 30px; color: #888;">Giỏ hàng trống</td></tr>`;
        }
    }

    // Chạy hàm cập nhật ngay khi vừa tải trang để đồng bộ số lượng ban đầu
    updateCartCount();

    // ==========================================
    // 2. XỬ LÝ SỰ KIỆN XÓA TỪNG CUỐN SÁCH
    // ==========================================
    const deleteButtons = document.querySelectorAll(".action-delete-btn");
    deleteButtons.forEach(btn => {
        btn.addEventListener("click", (e) => {
            // Tìm hàng (tr) chứa nút xóa vừa được bấm và xóa nó đi
            const row = e.target.closest("tr");
            if (row) {
                row.remove();
                // Sau khi xóa hàng đó, gọi lại hàm cập nhật để tính lại tổng số lượng
                updateCartCount();
            }
        });
    });

    // ==========================================
    // 3. XỬ LÝ SỰ KIỆN XÓA TẤT CẢ SÁCH
    // ==========================================
    const clearAllBtn = document.querySelector(".btn-clear-all");
    if (clearAllBtn) {
        clearAllBtn.addEventListener("click", () => {
            const tbody = document.querySelector(".items-table tbody");
            if (tbody) {
                tbody.innerHTML = ""; // Xóa sạch các hàng trong bảng
                updateCartCount();    // Cập nhật lại số lượng về 0
            }
        });
    }

    // ==========================================
    // 4. XỬ LÝ CHỨC NĂNG NGÀY TRẢ DỰ KIẾN
    // ==========================================
    const dateInput = document.getElementById("expectedReturnDate");
    if (dateInput) {
        const today = new Date();
        const defaultReturnDate = new Date();
        defaultReturnDate.setDate(today.getDate() + 7); // Mặc định mượn 7 ngày
        
        const formatDateString = (dateObj) => {
            const year = dateObj.getFullYear();
            const month = String(dateObj.getMonth() + 1).padStart(2, '0');
            const day = String(dateObj.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        };

        dateInput.value = formatDateString(defaultReturnDate);
        dateInput.min = formatDateString(today); // Không cho chọn ngày quá khứ
    }

    // ==========================================
    // 5. CHỨC NĂNG HOÀN TẤT MƯỢN SÁCH & LƯU LẠI DỮ LIỆU ĐỘNG
    // ==========================================
    const btnCompleteBorrow = document.querySelector(".btn-complete-borrow");

    if (btnCompleteBorrow) {
        btnCompleteBorrow.addEventListener("click", (e) => {
            e.preventDefault(); // Ngăn chặn tải lại trang mặc định
            
            // Kiểm tra xem giỏ hàng có sách hay không
            const bookRows = document.querySelectorAll(".items-table tbody tr");
            if (bookRows.length === 0) {
                alert("Giỏ sách của bạn đang trống! Vui lòng chọn sách trước khi mượn.");
                return;
            }

            // Thu thập dữ liệu từ giỏ hàng hiện tại
            const expectedReturnDateVal = document.getElementById("expectedReturnDate").value;
            const totalBooks = bookRows.length;
            
            // Sinh ngẫu nhiên một mã phiếu mượn mới (Ví dụ: PM4829, PM1029,...)
            const randomId = "PM" + Math.floor(1000 + Math.random() * 9000);
            
            // Lấy ngày mượn thực tế chính là ngày hôm nay (dd/mm/yyyy)
            const today = new Date();
            const formattedToday = `${String(today.getDate()).padStart(2, '0')}/${String(today.getMonth() + 1).padStart(2, '0')}/${today.getFullYear()}`;
            
            // Định dạng lại ngày trả từ YYYY-MM-DD sang DD/MM/YYYY để hiển thị đồng bộ dạng bảng
            let formattedReturnDate = "Chưa xác định";
            if(expectedReturnDateVal) {
                const rDate = new Date(expectedReturnDateVal);
                formattedReturnDate = `${String(rDate.getDate()).padStart(2, '0')}/${String(rDate.getMonth() + 1).padStart(2, '0')}/${rDate.getFullYear()}`;
            }

            // Gom dữ liệu thành một đối tượng Phiếu Mượn mới tinh ở trạng thái Chờ Duyệt
            const newTicket = {
                id: randomId,
                borrowDate: formattedToday,
                returnDate: formattedReturnDate,
                bookCount: totalBooks,
                status: "Chờ Duyệt"
            };

            // Lấy danh sách phiếu hiện tại có trong localStorage ra (nếu có), nếu chưa có thì tạo mảng rỗng
            let currentTickets = JSON.parse(localStorage.getItem("myTickets")) || [];
            
            // Thêm phiếu mới lên đầu danh sách
            currentTickets.unshift(newTicket);

            // Lưu ngược lại vào localStorage
            localStorage.setItem("myTickets", JSON.stringify(currentTickets));

            // Xóa sạch giỏ hàng tạm thời sau khi nhấn mượn thành công
            const tbody = document.querySelector(".items-table tbody");
            if(tbody) tbody.innerHTML = "";
            updateCartCount();

            // Chuyển hướng trình duyệt sang hẳn trang mới hiển thị bảng danh sách phiếu mượn
            window.location.href = "borrow-success.html"; 
        });
    }
});