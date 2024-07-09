package org.example.llm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, worldlllll";
    }
}