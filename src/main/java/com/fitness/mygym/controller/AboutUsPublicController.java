package com.fitness.mygym.controller;

import com.fitness.mygym.entity.AboutUs;
import com.fitness.mygym.service.AboutUsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("public/about-us")
@AllArgsConstructor
public class AboutUsPublicController {
    private final AboutUsService aboutUsService;
    @GetMapping("/get-first-active")
    public ResponseEntity getTopAboutUsActive() {
        AboutUs aboutUsTopActive = aboutUsService.findOneActive();
        if(Objects.nonNull(aboutUsTopActive)) {
            return ResponseEntity.ok().body(aboutUsTopActive);
        }
        return ResponseEntity.notFound().build();
    }
}
