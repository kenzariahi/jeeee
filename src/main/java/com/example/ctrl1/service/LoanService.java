package com.example.ctrl1.service;


import org.springframework.stereotype.Component;

import com.example.ctrl1.dao.entities.Loan;

import java.util.List;
@Component
public interface LoanService {
    List<Loan> getLoansByUserId(Long userId);
    void borrowBook(Long userId, Long bookId) throws Throwable;
    void returnBook(Long loanId);
}
