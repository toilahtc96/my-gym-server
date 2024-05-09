package com.fitness.mygym.request;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.dto.AboutPercentInfor;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.util.List;

@Getter
public class AboutUsRequest {
    @Nullable
    private Integer id;
    private String smallTitle;
    private String mainTitle;
    private String information;
    private List<AboutPercentInfor> benefitPercentInfo;
    private String image;
    @Enumerated(EnumType.STRING)
    private Status status;
}
