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
public class BlogEventTag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "blog_id")
    private int blogId;
    @Column(name = "tag_id")
    private int tagId;
    @Column(name = "event_id")
    private int eventId;
    @Enumerated(EnumType.STRING)
    private Status status;
}
