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
public class BlogTag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "blog_id")
    private int blogId;
    @Column(name = "tag_id")
    private int tagId;
    @Enumerated(EnumType.STRING)
    private Status status;
}
