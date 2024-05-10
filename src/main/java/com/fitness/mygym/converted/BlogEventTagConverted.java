package com.fitness.mygym.converted;

import com.fitness.mygym.entity.BlogEventTag;
import com.fitness.mygym.request.BlogEventTagRequest;

public class BlogEventTagConverted {
    public static BlogEventTag convertFromAddRequest(BlogEventTagRequest blogEventTagRequest) {
        return BlogEventTag.builder()
                .tagId(blogEventTagRequest.getTagId())
                .blogId(blogEventTagRequest.getBlogId())
                .eventId(blogEventTagRequest.getEventId())
                .status(blogEventTagRequest.getStatus())
                .build();
    }

}
