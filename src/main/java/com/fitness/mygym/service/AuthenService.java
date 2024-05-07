package com.fitness.mygym.service;

import com.fitness.mygym.converted.UserConverted;
import com.fitness.mygym.entity.User;
import com.fitness.mygym.repository.UserRepository;
import com.fitness.mygym.request.LoginRequest;
import com.fitness.mygym.request.RegisterRequest;
import com.fitness.mygym.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public String getTokenOfUser(LoginRequest request) {
        Optional<User> users = userRepository.findByUsername(request.getUsername());
        if(!users.isPresent()) {
            return null;
        }
        User user = users.get();
        if (user.getPassword() != null && user.getPassword().equals(request.getPassword())) {
            return jwtTokenProvider.generateToken(user);
        }
        return null;
    }

    public User register(RegisterRequest request) {
        return userRepository.save(UserConverted.convertFromRegister(request));
    }

}
