package com.power.likelion.controller;

import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.service.AnswerSerivce;
import com.power.likelion.utils.swagger.answer.CreateAnswerApiReq;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnswerController {

    private final AnswerSerivce answerSerivce;

    @CreateAnswerApiReq
    @PostMapping("/questions/{id}")
    public ResponseEntity<?> createAnswer(@PathVariable("id")Long id, @RequestBody AnswerReqDto answerReqDto){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(answerSerivce.createAnswer(id, answerReqDto))
                            .build());
        }
        catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }
    }
}
