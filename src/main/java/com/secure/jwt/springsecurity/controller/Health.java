package com.secure.jwt.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec-app")
public class Health {

    @GetMapping("/health")
    public String checkHealth(HttpServletRequest http){
        return "i ruuning good.. and my session id : "+http.getSession().getId();
    }
}
