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
public class Blog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    private String content;
    @Column(name = "category_id")
    private int categoryId;
}
