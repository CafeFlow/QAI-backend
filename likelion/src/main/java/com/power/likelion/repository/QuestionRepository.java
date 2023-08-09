package com.power.likelion.repository;

import com.power.likelion.domain.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findByTitleContaining(String searchKeyword, Pageable pageable);
    Page<Question> findByContentContaining(String searchKeyword, Pageable pageable);

    Page<Question> findByTitleContainingOrContentContaining(String title,String content, Pageable pageable);
}

