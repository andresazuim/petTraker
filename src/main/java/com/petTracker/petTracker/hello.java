package com.petTracker.petTracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class hello {

    @GetMapping
    public String olaMundo() {
        return "Hello World Spring!";
    }
}