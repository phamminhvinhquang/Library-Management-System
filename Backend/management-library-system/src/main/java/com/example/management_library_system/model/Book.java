package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;

    @Column(length = 100)
    private String bookName;

    @Column(length = 100)
    private String publisher;

    private Integer yearPublish;

    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String bookDetail;

    @Column(length = 500) 
    private String coverImage;

    @Column(name = "borrow_count")
    private Integer borrowCount = 0; // Mặc định khởi tạo là 0 lượt mượn

    // Khóa ngoại liên kết ngược lại với Category dựa trên cấu trúc ERD
    @ManyToOne
    @JoinColumn(name = "cateID")
    private Category category;

    // Mối quan hệ đa-đa với Author thông qua bảng trung gian Book_Author
    @ManyToMany
    @JoinTable(
        name = "Book_Author",
        joinColumns = @JoinColumn(name = "bookID"),
        inverseJoinColumns = @JoinColumn(name = "authorID")
    )
    private List<Author> authors;
}