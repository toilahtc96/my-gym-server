package com.fitness.mygym.repository;

import com.fitness.mygym.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
