package com.fitness.mygym.converted;


import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.User;
import com.fitness.mygym.request.RegisterRequest;
import com.fitness.mygym.request.UserRequest;

import java.time.LocalDateTime;

public class UserConverted {
    public static User convertUserRequest(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
//                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .roleId(userRequest.getRoleId())
                .status(Status.ACTIVE)
                .build();
    }

    public static User convertFromRegister(RegisterRequest registerRequest) {
        return User.builder()
                .name(registerRequest.getName() == null ? "anonymus" : registerRequest.getName())
//                .fullName(registerRequest.getFullName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
//                .createdTime(LocalDateTime.now())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .roleId(0)
                .status(Status.ACTIVE)
                .build();
    }
}
