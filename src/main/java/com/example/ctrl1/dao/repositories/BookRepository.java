package com.example.ctrl1.dao.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ctrl1.dao.entities.Book;
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByDesignationContains(String keyword, Pageable pageable);
}