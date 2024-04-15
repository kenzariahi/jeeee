package com.example.ctrl1.service;

import com.example.ctrl1.dao.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUserById(Long id);
    User getUserByUsername(String username);
    void saveUser(User user);
}
