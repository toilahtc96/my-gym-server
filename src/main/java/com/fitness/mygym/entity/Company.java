package com.fitness.mygym.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    @Column(name = "facebook_link")
    private String facebookLink;
    @Column(name = "tiktok_link")
    private String tiktokLink;
    @Column(name = "instagram_link")
    private String instagramLink;
}
