package com.app.codes.interview.rateLimiter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RateLimited
    @GetMapping("/resource")
    public String getResource() {
        return "Resource accessed";
    }
}