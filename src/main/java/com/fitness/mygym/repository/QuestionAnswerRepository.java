package com.fitness.mygym.repository;

import com.fitness.mygym.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Integer> {
}
