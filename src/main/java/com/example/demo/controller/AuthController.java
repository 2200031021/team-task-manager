package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    // Signup
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return repo.save(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return repo.findByEmail(user.getEmail());
    }
}