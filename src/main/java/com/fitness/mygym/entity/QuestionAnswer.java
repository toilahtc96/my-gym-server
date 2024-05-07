package com.fitness.mygym.entity;

import com.fitness.mygym.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionAnswer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String question;
    private String answer;
    @Column(name = "question_user_id")
    private int questionUserId;
    @Column(name = "answer_user_id")
    private int answerUserId;
    private int rate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
