package com.fitness.mygym.controller;

import com.fitness.mygym.entity.User;
import com.fitness.mygym.request.LoginRequest;
import com.fitness.mygym.request.RegisterRequest;
import com.fitness.mygym.service.AuthenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authentication")
@CrossOrigin(origins = {"http://localhost:3000"})
public class AuthController {

    private final AuthenService authenService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // Authenticate the user (e.g., using Spring Security's authentication manager)
        // If authentication is successful, generate a JWT
        String token = authenService.getTokenOfUser(request);
        if (token == null) {
            throw new AuthenticationServiceException("user not found");
        }
        return token;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        // Authenticate the user (e.g., using Spring Security's authentication manager)
        // If authentication is successful, generate a JWT
        User users = authenService.register(request);
        if (users == null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(users);
    }
}
