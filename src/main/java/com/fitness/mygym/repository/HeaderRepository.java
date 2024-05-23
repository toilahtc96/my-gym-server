package com.fitness.mygym.repository;

import com.fitness.mygym.constans.Status;
import com.fitness.mygym.entity.Header;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HeaderRepository extends PagingAndSortingRepository<Header, Integer>, JpaRepository<Header, Integer> {
    Header getByIdAndStatus(int id, Status status);

    Header getById(int id);
    List<Header> getByStatus(Status status);

    Header getFirstByStatus(Status status);

    Page<Header> findAll(Pageable pageable);
}
