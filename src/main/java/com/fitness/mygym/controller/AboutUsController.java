package com.fitness.mygym.controller;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.AboutUs;
import com.fitness.mygym.request.AboutUsRequest;
import com.fitness.mygym.service.AboutUsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/about-us")
@AllArgsConstructor
@Slf4j
public class AboutUsController {
    private final AboutUsService aboutUsService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AboutUsRequest aboutUsRequest) {
        AboutUs aboutUsAddEntity = aboutUsService.addAboutUs(aboutUsRequest);
        if(Objects.isNull(aboutUsAddEntity)) {
            log.error("add AboutUs Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody AboutUsRequest aboutUsRequest) {
        boolean edited = aboutUsService.editAboutUs(aboutUsRequest);
        if(!edited) {
            log.error("edit AboutUs Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        boolean blocked = aboutUsService.blockAboutUs(id);
        if(!blocked) {
            log.error("delete AboutUs Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        AboutUs getById = aboutUsService.findById(id);
        if(Objects.isNull(getById)) {
            log.error("get AboutUs Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(aboutUsService.getAll());
    }

    @GetMapping("/get-by-status")
    public ResponseEntity getByStatus(Status status) {
        return ResponseEntity.ok().body(aboutUsService.getAllByStatus(status));
    }
}
