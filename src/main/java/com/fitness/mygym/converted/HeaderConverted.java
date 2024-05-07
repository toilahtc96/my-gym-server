package com.fitness.mygym.converted;

import com.fitness.mygym.entity.Header;
import com.fitness.mygym.request.HeaderRequest;

import java.util.Objects;

public class HeaderConverted {
    public static Header convertFromAddRequest(HeaderRequest headerRequest) {
        return Header.builder()
                .firstTitle(headerRequest.getFirstTitle())
                .bigTitle(headerRequest.getBigTitle())
                .moreInformation(headerRequest.getMoreInformation())
                .image(headerRequest.getImage())
                .status(headerRequest.getStatus())
                .build();
    }

}
