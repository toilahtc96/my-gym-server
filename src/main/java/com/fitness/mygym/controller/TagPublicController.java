package com.fitness.mygym.controller;

import com.fitness.mygym.entity.Tag;
import com.fitness.mygym.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("public/tag")
@AllArgsConstructor
public class TagPublicController {
    private final TagService tagService;
}
