package com.power.likelion.repository;

import com.power.likelion.domain.board.Comment;
import com.power.likelion.domain.question.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBoardId(Long id);
}
