package com.fitness.mygym.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;
    @Column(name = "role_id")
    private int roleId;
    private String name;
    private String phone;
    private String email;
}
