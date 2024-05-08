package com.fitness.mygym.controller;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Service;
import com.fitness.mygym.request.ServiceRequest;
import com.fitness.mygym.service.PromoServiceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/service")
@AllArgsConstructor
@Slf4j
public class ServiceController {
    private final PromoServiceService serviceService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ServiceRequest serviceRequest) {
        Service serviceAddEntity = serviceService.addService(serviceRequest);
        if(Objects.isNull(serviceAddEntity)) {
            log.error("add Service Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody ServiceRequest serviceRequest) {
        boolean edited = serviceService.editService(serviceRequest);
        if(!edited) {
            log.error("edit Service Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        boolean blocked = serviceService.blockService(id);
        if(!blocked) {
            log.error("delete Service Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        Service getById = serviceService.findById(id);
        if(Objects.isNull(getById)) {
            log.error("get Service Error");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(serviceService.getAll());
    }

    @GetMapping("/get-by-status")
    public ResponseEntity getByStatus(Status status) {
        return ResponseEntity.ok().body(serviceService.getAllByStatus(status));
    }
}
