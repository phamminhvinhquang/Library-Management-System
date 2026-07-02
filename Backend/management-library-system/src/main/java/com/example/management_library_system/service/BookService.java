package com.example.management_library_system.service;

import com.example.management_library_system.model.Book;
import com.example.management_library_system.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooksForHome() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
    return bookRepository.findById(id).orElse(null);
}
}