package com.fitness.mygym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/hello")
public class HelloController {
    @GetMapping("/get")
    public String hello() {
        return "Hello";
    }
}
