package com.fitness.mygym.entity;

import com.fitness.mygym.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "pt_id")
    private Integer ptId;
    private LocalDate date;
    private LocalTime time;
    @Column(length = 2000)
    private String address;
    @Column(length = 2000)
    private String image;
    @Column(length = Integer.MAX_VALUE)
    private String content;
    @Enumerated(EnumType.STRING)
    private Status status;
}
