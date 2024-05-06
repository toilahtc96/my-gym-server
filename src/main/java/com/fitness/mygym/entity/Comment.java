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
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String content;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "blog_id")
    private int blogId;
}
