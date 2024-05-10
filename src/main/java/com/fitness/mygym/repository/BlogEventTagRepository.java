package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.BlogEventTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogEventTagRepository extends JpaRepository<BlogEventTag, Integer> {


    BlogEventTag getById(int id);
    List<BlogEventTag> getByStatus(Status status);

    BlogEventTag getFirstByStatus(Status status);
    List<BlogEventTag> getAllByEventId(int eventId);
    List<BlogEventTag> getAllByBlogId(int eventId);
}
