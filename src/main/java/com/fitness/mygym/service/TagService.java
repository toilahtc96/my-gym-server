package com.fitness.mygym.service;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.converted.TagConverted;
import com.fitness.mygym.entity.Tag;
import com.fitness.mygym.repository.TagRepository;
import com.fitness.mygym.request.TagRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag addTag(TagRequest tagRequest) {
        return tagRepository.save(TagConverted.convertFromAddRequest(tagRequest));
    }

    public boolean editTag(TagRequest tagRequest) {
        if (Objects.nonNull(tagRequest.getId())) {
            Optional<Tag> optionTagById = tagRepository.findById(tagRequest.getId());
            if (optionTagById.isPresent()) {
                Tag tagById = optionTagById.get();
                tagById.setName(tagRequest.getName());
                tagRepository.save(tagById);
                return true;
            }
        }
        return false;
    }

    public Tag findById(int id) {
        return tagRepository.findById(id).get();
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public List<Tag> getAllByStatus(Status status) {
        return tagRepository.getByStatus(status);
    }

    public List<Tag> findThreeActive() {
        return tagRepository.getByStatus(Status.ACTIVE);
    }
}
