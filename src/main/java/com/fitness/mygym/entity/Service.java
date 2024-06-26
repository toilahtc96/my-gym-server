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
public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    @Column(length = 5000)
    private String information;
    @Column(length = 5000)
    private String icon;
    @Column(length = 5000)
    private String background;
    @Enumerated(EnumType.STRING)
    private Status status;
}
