package com.fitness.mygym.converted;

import com.fitness.mygym.entity.AboutUs;
import com.fitness.mygym.request.AboutUsRequest;
import com.google.gson.Gson;

public class AboutUsConverted {
    static Gson gson = new Gson();
    public static AboutUs convertFromAddRequest(AboutUsRequest aboutUsRequest) {
        return AboutUs.builder()
                .smallTitle(aboutUsRequest.getSmallTitle())
                .mainTitle(aboutUsRequest.getMainTitle())
                .information(aboutUsRequest.getInformation())
                .benefitPercentInfo(gson.toJson(aboutUsRequest.getBenefitPercentInfo()))
                .image(aboutUsRequest.getImage())
                .status(aboutUsRequest.getStatus())
                .build();
    }

}
