package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorID;

    @Column(length = 100)
    private String authorName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}