package com.fitness.mygym.converted;

import com.fitness.mygym.entity.AboutUs;
import com.fitness.mygym.entity.Tag;
import com.fitness.mygym.request.AboutUsRequest;
import com.fitness.mygym.request.TagRequest;

public class TagConverted {
    public static Tag convertFromAddRequest(TagRequest tagRequest) {
        return Tag.builder()
                .name(tagRequest.getName())
                .build();
    }

}
