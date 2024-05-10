package com.fitness.mygym.request;

import com.fitness.mygym.constans.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class TagRequest {
    @Nullable
    private Integer id;
    private String name;
}
