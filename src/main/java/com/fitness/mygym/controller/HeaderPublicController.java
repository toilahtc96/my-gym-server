package com.fitness.mygym.controller;

import com.fitness.mygym.entity.Header;
import com.fitness.mygym.service.HeaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("public/header")
@AllArgsConstructor
public class HeaderPublicController {
    private final HeaderService headerService;
    @GetMapping("/get-first-active")
    public ResponseEntity getTopHeaderActive() {
        Header headerTopActive = headerService.findFirstActive();
        if(Objects.nonNull(headerTopActive)) {
            return ResponseEntity.ok().body(headerTopActive);
        }
        return ResponseEntity.notFound().build();
    }
}
