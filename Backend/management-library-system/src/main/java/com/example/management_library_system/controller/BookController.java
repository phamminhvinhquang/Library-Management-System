package com.example.management_library_system.controller;
import com.example.management_library_system.model.Book;
import com.example.management_library_system.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "*") // Đảm bảo giao diện gọi dữ liệu mượt mà không bị chặn lỗi CORS
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // API phục vụ riêng dữ liệu danh sách sách hiển thị tại thanh cuộn (Slider) trang chủ
    @GetMapping("/books")
    public List<Book> getBooksForHomePage() {
        return bookService.getAllBooksForHome();
    }

    // API lấy chi tiết 1 cuốn sách theo ID
    @GetMapping("/{id}")
    public Book getBookDetail(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }
}
