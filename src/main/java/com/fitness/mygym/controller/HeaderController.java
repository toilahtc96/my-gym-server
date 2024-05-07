package com.fitness.mygym.controller;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Header;
import com.fitness.mygym.request.HeaderRequest;
import com.fitness.mygym.service.HeaderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/header")
@AllArgsConstructor
@Slf4j
public class HeaderController {
    private final HeaderService headerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody HeaderRequest headerRequest) {
        Header headerAddEntity = headerService.addHeader(headerRequest);
        if(Objects.isNull(headerAddEntity)) {
            log.error("add Header Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody HeaderRequest headerRequest) {
        boolean edited = headerService.editHeader(headerRequest);
        if(!edited) {
            log.error("edit Header Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        boolean blocked = headerService.blockHeader(id);
        if(!blocked) {
            log.error("delete Header Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        Header getById = headerService.findById(id);
        if(Objects.isNull(getById)) {
            log.error("get Header Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(headerService.getAll());
    }

    @GetMapping("/get-by-status")
    public ResponseEntity getByStatus(Status status) {
        return ResponseEntity.ok().body(headerService.getAllByStatus(status));
    }
}
