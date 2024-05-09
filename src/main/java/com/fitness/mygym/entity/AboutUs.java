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
public class AboutUs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "small_title")
    private String smallTitle;
    @Column(name = "main_title")
    private String mainTitle;
    @Column(length = 5000)
    private String information;
    @Column(name = "benefit_percent-info",length = 5000)
    private String benefitPercentInfo;
    @Column(length = 1000)
    private String image;
    @Enumerated(EnumType.STRING)
    private Status status;
}
