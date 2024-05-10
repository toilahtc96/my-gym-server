package com.fitness.mygym.controller;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.BlogEventTag;
import com.fitness.mygym.request.BlogEventTagRequest;
import com.fitness.mygym.service.BlogEventTagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/blog-event-blogEventTag")
@AllArgsConstructor
@Slf4j
public class BlogEventTagController {
    private final BlogEventTagService blogEventTagService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody BlogEventTagRequest blogEventBlogEventTagRequest) {
        BlogEventTag blogEventTagAddEntity = blogEventTagService.addTag(blogEventBlogEventTagRequest);
        if(Objects.isNull(blogEventTagAddEntity)) {
            log.error("add BlogEventTag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody BlogEventTagRequest blogEventBlogEventTagRequest) {
        boolean edited = blogEventTagService.editTag(blogEventBlogEventTagRequest);
        if(!edited) {
            log.error("edit BlogEventTag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        BlogEventTag getById = blogEventTagService.findById(id);
        if(Objects.isNull(getById)) {
            log.error("get BlogEventTag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(blogEventTagService.getAll());
    }

    @GetMapping("/get-by-status")
    public ResponseEntity getByStatus(Status status) {
        return ResponseEntity.ok().body(blogEventTagService.getAllByStatus(status));
    }
}
