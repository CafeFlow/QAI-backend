package com.power.likelion.controller;

import com.power.likelion.dto.question.QuesReqDto;
import com.power.likelion.dto.question.QuesResDto;
import com.power.likelion.service.QuestionService;
import com.power.likelion.utils.swagger.question.GetAllQuesRequest;
import com.power.likelion.utils.swagger.question.QuesApiRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;


@Tag(name = "Q&A 생성, 조회, 수정, 삭제", description = "질문을 올리고 수정하고 삭제하고 조회할 수 있다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    /** 질문 생성 */
    @QuesApiRequest
    @PostMapping("/create")
    public ResponseEntity<?> createQuestion(@RequestBody QuesReqDto quesReqDto) {
        try{
            QuesResDto quesResDto=questionService.createQuestion(quesReqDto);
            return ResponseEntity.status(HttpStatus.OK).body(quesResDto);
        }
        catch(Exception e){ // 유저가 존재하지 않을 경우
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetAllQuesRequest
    @GetMapping("/{page}")
    public ResponseEntity<?> getAllQuestion(@PathVariable("page") Integer page) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestions(page));
    }
}