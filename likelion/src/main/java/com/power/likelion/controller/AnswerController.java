package com.power.likelion.controller;

import com.power.likelion.common.exception.AuthorMismatchException;
import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.service.AnswerSerivce;
import com.power.likelion.utils.swagger.answer.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
@Tag(name = "답변 생성, 수정, 삭제, 채택", description = "답변 CRUD + 채택기능")
public class AnswerController {

    private final AnswerSerivce answerSerivce;

    @CreateAnswerApiReq
    @PostMapping("/answer/{id}")
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

    @UpdateAnswerApiReq
    @PatchMapping("/answer/{id}")
    public ResponseEntity<?> updateAnswer(@PathVariable("id") Long id, @RequestBody AnswerReqDto answerReqDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(answerSerivce.updateAns(id,answerReqDto))
                            .build());

        }
        catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }
        catch(AuthorMismatchException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }

    }

    @DeleteAnswerApiReq
    @DeleteMapping("/answer/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") Long id){
        try{
            answerSerivce.deleteAns(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                                    .result(null)
                                    .build());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }

    }

    /** 채택 기능 구현*/
    @CheckAnswerApiReq
    @CheckAnswerApiRes
    @PostMapping("/answer/check")
    public ResponseEntity<?> answerCheck(@RequestParam("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(answerSerivce.answerCheck(id))
                            .build());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }

    }
}
