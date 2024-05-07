package com.fitness.mygym.request;

import com.fitness.mygym.constans.Status;
import lombok.Getter;

@Getter
public class UserRequest {
    private Integer id;
    private String name;
    private int roleId;
    private String fullName;
    private String phone;
    private String email;
    private Status status;
}
