package com.example.ctrl1.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

import com.example.ctrl1.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByDesignationContains(String keyword, Pageable pageable);

    User findByUsername(String username);
}
