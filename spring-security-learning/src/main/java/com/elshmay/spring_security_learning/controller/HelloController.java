package com.elshmay.spring_security_learning.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security";
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "Hi User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Hello Admin";
    }
}