package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Service getByIdAndStatus(int id, Status status);

    Service getById(int id);
    List<Service> getByStatus(Status status);

    Service getFirstByStatus(Status status);
}
