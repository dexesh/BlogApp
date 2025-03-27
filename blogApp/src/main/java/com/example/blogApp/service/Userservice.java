package com.example.blogApp.service;

import com.example.blogApp.entity.User;
import com.example.blogApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }
}
