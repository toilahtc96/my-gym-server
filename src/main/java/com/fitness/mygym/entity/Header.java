package com.fitness.mygym.entity;

import com.fitness.mygym.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Header implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "first_title")
    private String firstTitle;
    @Column(name = "big_title")
    private String bigTitle;
    @Column(name = "more_information")
    private String moreInformation;
    private String image;
    @Enumerated(EnumType.STRING)
    private Status status;
}
