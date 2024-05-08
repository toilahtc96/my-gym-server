package com.fitness.mygym.controller;

import com.fitness.mygym.entity.Service;
import com.fitness.mygym.service.PromoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("public/service")
@AllArgsConstructor
public class ServicePublicController {
    private final PromoServiceService serviceService;
    @GetMapping("/get-six-active")
    public ResponseEntity getTopServiceActive() {
        List<Service> serviceTopActive = serviceService.getSixActive();
        if(Objects.nonNull(serviceTopActive)) {
            return ResponseEntity.ok().body(serviceTopActive);
        }
        return ResponseEntity.notFound().build();
    }
}
