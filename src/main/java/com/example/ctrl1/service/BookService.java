package com.example.ctrl1.service;


import com.example.ctrl1.dao.entities.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void saveBook(Book book);
}
