package com.fitness.mygym.request;

import com.fitness.mygym.constans.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class ServiceRequest {
    @Nullable
    private Integer id;
    private String title;
    private String information;
    private String icon;
    private String background;
    @Enumerated(EnumType.STRING)
    private Status status;
}
