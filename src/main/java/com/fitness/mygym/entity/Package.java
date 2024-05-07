package com.fitness.mygym.entity;

import com.fitness.mygym.constans.Status;
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
public class Package {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String information;
    @Column(name = "why_choose")
    private String whyChoose;
    private String benefit;
    private String image;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "pt_id")
    private int ptId;
    @Enumerated(EnumType.STRING)
    private Status status;
}
