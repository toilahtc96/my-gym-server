package com.fitness.mygym.service;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.converted.ServiceConverted;
import com.fitness.mygym.entity.Service;
import com.fitness.mygym.repository.ServiceRepository;
import com.fitness.mygym.request.ServiceRequest;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class PromoServiceService {

    private final ServiceRepository serviceRepository;

    public Service addService(ServiceRequest serviceRequest) {
        return serviceRepository.save(ServiceConverted.convertFromAddRequest(serviceRequest));
    }

    public boolean editService(ServiceRequest serviceRequest) {
        if (Objects.nonNull(serviceRequest.getId())) {
            Service serviceById = serviceRepository.getByIdAndStatus(serviceRequest.getId(), serviceRequest.getStatus());
            if (Objects.nonNull(serviceById)) {
                serviceById.setBackground(serviceRequest.getBackground());
                serviceById.setIcon(serviceRequest.getIcon());
                serviceById.setTitle(serviceRequest.getTitle());
                serviceById.setInformation(serviceRequest.getInformation());
                serviceById.setStatus(serviceRequest.getStatus());
                serviceRepository.save(serviceById);
                return true;
            }
        }
        return false;
    }

    public boolean blockService(int id) {
        Service serviceById = serviceRepository.getByIdAndStatus(id, Status.ACTIVE);
        if (Objects.nonNull(serviceById)) {
            serviceById.setStatus(Status.BLOCK);
            serviceRepository.save(serviceById);
            return true;
        }
        return false;
    }

    public Service findById(int id) {
        return serviceRepository.findById(id).get();
    }

    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    public List<Service> getAllByStatus(Status status) {
        return serviceRepository.getByStatus(status);
    }

    public Service findFirstActive() {
        return serviceRepository.getFirstByStatus(Status.ACTIVE);
    }

    public List<Service> getSixActive() {
        List<Service> allService = serviceRepository.getByStatus(Status.ACTIVE);
        if(!CollectionUtils.isEmpty(allService)) {
            if(allService.size() < 6) {
                return allService.subList(0,5);
            }
            return allService;
        }
        return new ArrayList<>();
    }
}
