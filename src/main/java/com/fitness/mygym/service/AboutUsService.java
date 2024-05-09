package com.fitness.mygym.service;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.converted.AboutUsConverted;
import com.fitness.mygym.entity.AboutUs;
import com.fitness.mygym.repository.AboutUsRepository;
import com.fitness.mygym.request.AboutUsRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AboutUsService {
    private final AboutUsRepository aboutUsRepository;

    public AboutUs addAboutUs(AboutUsRequest aboutUsRequest) {
        return aboutUsRepository.save(AboutUsConverted.convertFromAddRequest(aboutUsRequest));
    }

    public boolean editAboutUs(AboutUsRequest aboutUsRequest) {
        if (Objects.nonNull(aboutUsRequest.getId())) {
            AboutUs aboutUsById = aboutUsRepository.getByIdAndStatus(aboutUsRequest.getId(), aboutUsRequest.getStatus());
            if (Objects.nonNull(aboutUsById)) {
                aboutUsById.setSmallTitle(aboutUsRequest.getSmallTitle());
                aboutUsById.setMainTitle(aboutUsRequest.getMainTitle());
                aboutUsById.setInformation(aboutUsRequest.getInformation());
                aboutUsById.setBenefitPercentInfo(aboutUsRequest.getBenefitPercentInfo().toString());
                aboutUsById.setStatus(aboutUsRequest.getStatus());
                aboutUsById.setImage(aboutUsRequest.getImage());
                aboutUsRepository.save(aboutUsById);
                return true;
            }
        }
        return false;
    }

    public boolean blockAboutUs(int id) {
        AboutUs aboutUsById = aboutUsRepository.getByIdAndStatus(id, Status.ACTIVE);
        if (Objects.nonNull(aboutUsById)) {
            aboutUsById.setStatus(Status.BLOCK);
            aboutUsRepository.save(aboutUsById);
            return true;
        }
        return false;
    }

    public AboutUs findById(int id) {
        return aboutUsRepository.findById(id).get();
    }

    public List<AboutUs> getAll() {
        return aboutUsRepository.findAll();
    }

    public List<AboutUs> getAllByStatus(Status status) {
        return aboutUsRepository.getByStatus(status);
    }

    public AboutUs findOneActive() {
        return aboutUsRepository.getFirstByStatus(Status.ACTIVE);
    }
}
