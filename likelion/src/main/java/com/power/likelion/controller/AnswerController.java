package com.power.likelion.controller;

import com.power.likelion.common.exception.AuthorMismatchException;
import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.service.AnswerSerivce;
import com.power.likelion.utils.swagger.answer.CreateAnswerApiReq;
import com.power.likelion.utils.swagger.answer.DeleteAnswerApiReq;
import com.power.likelion.utils.swagger.answer.UpdateAnswerApiReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/questions")
@Tag(name = "답변 생성, 수정, 삭제", description = "답변을 생성하고 생성한 답변을 수정하고 삭제한다.")
public class AnswerController {

    private final AnswerSerivce answerSerivce;

    @CreateAnswerApiReq
    @PostMapping("/{id}")
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
}
