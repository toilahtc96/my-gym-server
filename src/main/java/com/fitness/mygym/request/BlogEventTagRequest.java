package com.fitness.mygym.request;

import com.fitness.mygym.constans.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class BlogEventTagRequest {
    @Nullable
    private Integer id;
    private int blogId;
    private int tagId;
    private int eventId;
    @Enumerated(EnumType.STRING)
    private Status status;
}
