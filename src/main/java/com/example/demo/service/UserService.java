package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return existingUser;
        }

        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}