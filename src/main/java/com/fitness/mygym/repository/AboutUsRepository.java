package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutUsRepository extends JpaRepository<AboutUs, Integer> {
    AboutUs getByIdAndStatus(int id, Status status);

    AboutUs getById(int id);
    List<AboutUs> getByStatus(Status status);

    AboutUs getFirstByStatus(Status status);
}
