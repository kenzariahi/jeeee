package com.example.ctrl1.service;


import com.example.ctrl1.dao.entities.Book;
import com.example.ctrl1.dao.entities.Loan;
import com.example.ctrl1.dao.entities.User;
import com.example.ctrl1.dao.repositories.BookRepository;
import com.example.ctrl1.dao.repositories.LoanRepository;
import com.example.ctrl1.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Loan> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    @Override
    public void borrowBook(Long userId, Long bookId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = (Book) bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(new Date());

        loanRepository.save(loan);
    }

    @Override
    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setReturnDate(new Date());
        loanRepository.save(loan);
    }
}
