package com.nbs.marketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Test protected endpoint
    @GetMapping("/api/test")
    public String test() {
        return "JWT Authentication Successful!";
    }
}