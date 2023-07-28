package com.power.likelion.repository;

import com.power.likelion.domain.question.Answer;
import com.power.likelion.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long id);
}
