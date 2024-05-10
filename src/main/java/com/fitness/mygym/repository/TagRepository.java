package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Header;
import com.fitness.mygym.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {


    Tag getById(int id);
    List<Tag> getByStatus(Status status);

    Tag getFirstByStatus(Status status);
}
