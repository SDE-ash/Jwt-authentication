package com.secure.jwt.springsecurity.controller;

import com.secure.jwt.springsecurity.entity.User;
import com.secure.jwt.springsecurity.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContrl {

    @Autowired
    private UserServices userServices;

    @PostMapping("/save-user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return userServices.saveUser(user);
    }

    @GetMapping("/login")
    public String login(@RequestBody User user){
        return userServices.verify(user);
    }
}
