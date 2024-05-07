package com.fitness.mygym.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.mygym.constans.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class HeaderRequest {
    @Nullable
    private Integer id;
    private String firstTitle;
    private String bigTitle;
    private String moreInformation;
    private String image;
    @Enumerated(EnumType.STRING)
    private Status status;
}
