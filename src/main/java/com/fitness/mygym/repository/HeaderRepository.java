package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaderRepository extends JpaRepository<Header, Integer> {
    Header getByIdAndStatus(int id, Status status);

    Header getById(int id);
    List<Header> getByStatus(Status status);
}
