package com.example.ctrl1.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ctrl1.dao.entities.Loan;

import java.util.*;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Page<Loan> findByDesignationContains(String keyword, Pageable pageable);

    List<Loan> findByUserId(Long userId);
}
