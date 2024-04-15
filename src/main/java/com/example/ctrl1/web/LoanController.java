package com.example.ctrl1.web;


import com.example.ctrl1.dao.entities.Loan;
import com.example.ctrl1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUserId(@PathVariable Long userId) {
        return loanService.getLoansByUserId(userId);
    }

    @PostMapping("/borrow/{userId}/{bookId}")
    public void borrowBook(@PathVariable Long userId, @PathVariable Long bookId) throws Throwable {
        loanService.borrowBook(userId, bookId);
    }

    @PutMapping("/return/{loanId}")
    public void returnBook(@PathVariable Long loanId) {
        loanService.returnBook(loanId);
    }
}
