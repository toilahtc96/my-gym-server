package com.fitness.mygym.controller;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Tag;
import com.fitness.mygym.request.TagRequest;
import com.fitness.mygym.service.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/tag")
@AllArgsConstructor
@Slf4j
public class TagController {
    private final TagService tagService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody TagRequest tagRequest) {
        Tag tagAddEntity = tagService.addTag(tagRequest);
        if(Objects.isNull(tagAddEntity)) {
            log.error("add Tag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody TagRequest tagRequest) {
        boolean edited = tagService.editTag(tagRequest);
        if(!edited) {
            log.error("edit Tag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        Tag getById = tagService.findById(id);
        if(Objects.isNull(getById)) {
            log.error("get Tag Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(tagService.getAll());
    }

    @GetMapping("/get-by-status")
    public ResponseEntity getByStatus(Status status) {
        return ResponseEntity.ok().body(tagService.getAllByStatus(status));
    }
}
