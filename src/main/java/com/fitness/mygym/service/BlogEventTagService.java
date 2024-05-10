package com.fitness.mygym.service;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.converted.BlogEventTagConverted;
import com.fitness.mygym.entity.BlogEventTag;
import com.fitness.mygym.repository.BlogEventTagRepository;
import com.fitness.mygym.request.BlogEventTagRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogEventTagService {
    private final BlogEventTagRepository blogEventTagRepository;

    public BlogEventTag addTag(BlogEventTagRequest blogEventTagRequest) {
        return blogEventTagRepository.save(BlogEventTagConverted.convertFromAddRequest(blogEventTagRequest));
    }

    public boolean editTag(BlogEventTagRequest blogEventTagRequest) {
        if (Objects.nonNull(blogEventTagRequest.getId())) {
            Optional<BlogEventTag> optionTagById = blogEventTagRepository.findById(blogEventTagRequest.getId());
            if (optionTagById.isPresent()) {
                BlogEventTag blogEventTagById = optionTagById.get();
                blogEventTagById.setTagId(blogEventTagRequest.getTagId());
                blogEventTagById.setEventId(blogEventTagRequest.getEventId());
                blogEventTagById.setBlogId(blogEventTagRequest.getBlogId());
                blogEventTagById.setStatus(blogEventTagById.getStatus());
                blogEventTagRepository.save(blogEventTagById);
                return true;
            }
        }
        return false;
    }

    public BlogEventTag findById(int id) {
        return blogEventTagRepository.findById(id).get();
    }

    public List<BlogEventTag> getAll() {
        return blogEventTagRepository.findAll();
    }

    public List<BlogEventTag> getAllByStatus(Status status) {
        return blogEventTagRepository.getByStatus(status);
    }

    public List<BlogEventTag> getAllByEventId(int eventId) {
        return blogEventTagRepository.getAllByEventId(eventId);
    }
    public List<BlogEventTag> getAllByBlogId(int blogId) {
        return blogEventTagRepository.getAllByBlogId(blogId);
    }
    //    getListTagIdByBlogId,getListTagIdByEventId
    public List<Integer> getListTagIdByEventId(int eventId) {
        return blogEventTagRepository.getAllByEventId(eventId).stream().map(BlogEventTag::getTagId).collect(Collectors.toList());
    }

    public List<Integer> getListTagIdByBlogId(int blogId) {
        return blogEventTagRepository.getAllByBlogId(blogId).stream().map(BlogEventTag::getTagId).collect(Collectors.toList());
    }
}
