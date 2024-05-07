package com.fitness.mygym.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String name;
    private String fullName;
    private String phone;
    private String email;
}
