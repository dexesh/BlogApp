package com.example.blogApp.controller;

import com.example.blogApp.entity.User;
import com.example.blogApp.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {
@Autowired
    private Userservice userservice;
@PostMapping
    public User createUser(@RequestBody User user){
    return userservice.createUser(user);
}
}
