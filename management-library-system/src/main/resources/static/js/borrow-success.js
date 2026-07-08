/**
 * Quản lý trạng thái và kiểm tra điều kiện phiếu mượn sách
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