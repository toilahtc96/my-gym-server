package com.fitness.mygym.service;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.converted.HeaderConverted;
import com.fitness.mygym.entity.Header;
import com.fitness.mygym.repository.HeaderRepository;
import com.fitness.mygym.request.HeaderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class HeaderService {
    //    getActive getall getById crud getbyStatus
    private final HeaderRepository headerRepository;

    public Header addHeader(HeaderRequest headerRequest) {
        return headerRepository.save(HeaderConverted.convertFromAddRequest(headerRequest));
    }

    public boolean editHeader(HeaderRequest headerRequest) {
        if (Objects.nonNull(headerRequest.getId())) {
            Header headerById = headerRepository.getByIdAndStatus(headerRequest.getId(), headerRequest.getStatus());
            if (Objects.nonNull(headerById)) {
                headerById.setFirstTitle(headerRequest.getFirstTitle());
                headerById.setBigTitle(headerRequest.getBigTitle());
                headerById.setMoreInformation(headerRequest.getMoreInformation());
                headerById.setImage(headerRequest.getImage());
                headerById.setStatus(headerRequest.getStatus());
                headerRepository.save(headerById);
                return true;
            }
        }
        return false;
    }

    public boolean blockHeader(int id) {
        Header headerById = headerRepository.getByIdAndStatus(id, Status.ACTIVE);
        if (Objects.nonNull(headerById)) {
            headerById.setStatus(Status.BLOCK);
            headerRepository.save(headerById);
            return true;
        }
        return false;
    }

    public Header findById(int id) {
        return headerRepository.findById(id).get();
    }

    public List<Header> getAll() {
        return headerRepository.findAll();
    }

    public List<Header> getAllByStatus(Status status) {
        return headerRepository.getByStatus(status);
    }

    public Header findFirstActive() {
        return headerRepository.getFirstByStatus(Status.ACTIVE);
    }
}
