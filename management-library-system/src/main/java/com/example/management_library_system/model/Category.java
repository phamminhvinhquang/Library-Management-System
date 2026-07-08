package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
@Data // Lombok tự tạo getter, setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateID;

    @Column(length = 30)
    private String cateName;

    // 1 Thể loại có nhiều Sách
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Book> books;
}