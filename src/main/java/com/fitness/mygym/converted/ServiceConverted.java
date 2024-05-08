package com.fitness.mygym.converted;

import com.fitness.mygym.entity.Header;
import com.fitness.mygym.entity.Service;
import com.fitness.mygym.request.HeaderRequest;
import com.fitness.mygym.request.ServiceRequest;

public class ServiceConverted {
    public static Service convertFromAddRequest(ServiceRequest serviceRequest) {
        return Service.builder()
                .title(serviceRequest.getTitle())
                .information(serviceRequest.getInformation())
                .icon(serviceRequest.getIcon())
                .background(serviceRequest.getBackground())
                .status(serviceRequest.getStatus())
                .build();
    }

}
