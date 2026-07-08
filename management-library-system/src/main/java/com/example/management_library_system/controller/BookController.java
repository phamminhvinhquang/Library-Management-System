package com.example.management_library_system.controller;

import com.example.management_library_system.model.Author;
import com.example.management_library_system.model.Book;
import com.example.management_library_system.model.Category;
import com.example.management_library_system.repository.AuthorRepository;
import com.example.management_library_system.repository.BookRepository;
import com.example.management_library_system.repository.CategoryRepository;
import com.example.management_library_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "*") 
public class BookController {
    private final BookService bookService;

    // Tiêm Repository vào để xử lý trực tiếp các thao tác Sửa/Xóa
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. Lấy danh sách sách
    @GetMapping("/books")
    public List<Book> getBooksForHomePage() {
        return bookService.getAllBooksForHome();
    }

    // 2. Lấy chi tiết sách
    @GetMapping("/{id}")
    public Book getBookDetail(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    // =======================================================
    // 3. API SỬA THÔNG TIN SÁCH
    // =======================================================
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@RequestHeader("Authorization") String token, @PathVariable Integer id, @RequestBody Book bookDetails) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("message", "Không tìm thấy sách!"));
        }

        Book existingBook = bookOpt.get();
        // Cập nhật các trường thông tin (Không sửa bookID)
        existingBook.setBookName(bookDetails.getBookName());
        existingBook.setPublisher(bookDetails.getPublisher());
        existingBook.setYearPublish(bookDetails.getYearPublish());
        existingBook.setQuantity(bookDetails.getQuantity());
        existingBook.setBookDetail(bookDetails.getBookDetail());

        bookRepository.save(existingBook); // Lưu đè xuống MySQL
        return ResponseEntity.ok(Map.of("message", "Cập nhật sách thành công!"));
    }

    // =======================================================
    // 4. API XÓA SÁCH
    // =======================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Xóa sách thành công!"));
        } catch (Exception e) {
            // Lỗi xảy ra thường do khóa ngoại (Sách này đang nằm trong 1 thẻ mượn nào đó)
            return ResponseEntity.status(400).body(Map.of("message", "Không thể xóa cuốn sách này vì đang có độc giả mượn!"));
        }
    }

    // =======================================================
    // 5. API THÊM SÁCH MỚI
    // =======================================================
    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> payload) {
        try {
            Book book = new Book();
            book.setBookName((String) payload.get("bookName"));
            book.setPublisher((String) payload.get("publisher"));
            book.setBookDetail((String) payload.get("bookDetail"));
            book.setCoverImage((String) payload.get("coverImage"));

            // Nhận số lượng và năm xuất bản từ Frontend gửi lên
            if (payload.get("yearPublish") != null && !payload.get("yearPublish").toString().isEmpty()) {
                book.setYearPublish(Integer.parseInt(payload.get("yearPublish").toString()));
            }
            if (payload.get("quantity") != null && !payload.get("quantity").toString().isEmpty()) {
                book.setQuantity(Integer.parseInt(payload.get("quantity").toString()));
            } else {
                book.setQuantity(1); // Mặc định là 1 nếu không điền
            }

            // 1. XỬ LÝ THỂ LOẠI (CATEGORY): Tìm trong DB, nếu chưa có thì tự động tạo mới
            String cateName = (String) payload.get("categoryName");
            if (cateName != null && !cateName.trim().isEmpty()) {
                Category category = categoryRepository.findByCateName(cateName.trim())
                    .orElseGet(() -> {
                        Category newCate = new Category();
                        newCate.setCateName(cateName.trim());
                        return categoryRepository.save(newCate); // Lưu thể loại mới xuống MySQL
                    });
                book.setCategory(category);
            }

            // 2. XỬ LÝ TÁC GIẢ (AUTHOR): Tìm trong DB, nếu chưa có thì tự động tạo mới
            String authorName = (String) payload.get("authorName");
            if (authorName != null && !authorName.trim().isEmpty()) {
                Author author = authorRepository.findByAuthorName(authorName.trim())
                    .orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setAuthorName(authorName.trim());
                        return authorRepository.save(newAuthor); // Lưu tác giả mới xuống MySQL
                    });
                book.setAuthors(List.of(author)); // Gán tác giả vào sách
            }

            // 3. LƯU CHÍNH THỨC CUỐN SÁCH VÀO MYSQL
            bookRepository.save(book);
            return ResponseEntity.ok(Map.of("message", "Thêm sách thành công!"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("message", "Lỗi khi thêm sách: " + e.getMessage()));
        }
    }
}