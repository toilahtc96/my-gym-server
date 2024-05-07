package com.fitness.mygym.repository;

import com.fitness.mygym.entity.PtUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtUserRepository extends JpaRepository<PtUser, Integer> {
}
