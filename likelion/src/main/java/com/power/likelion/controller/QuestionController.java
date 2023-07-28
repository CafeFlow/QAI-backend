package com.power.likelion.controller;

import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.question.QuesReqDto;
import com.power.likelion.dto.question.QuesResDto;
import com.power.likelion.dto.question.QuesUpdateDto;
import com.power.likelion.service.QuestionService;
import com.power.likelion.utils.swagger.question.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(quesResDto)
                            .build());
        }
        catch(Exception e){ // 유저가 존재하지 않을 경우
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetAllQuesRequest
    @GetMapping(name="page")
    public ResponseEntity<?> getAllQuestion(@RequestParam("page") Integer page) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestions(page));
    }


    @GetQuesApiRequest
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable("id") Long id) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(questionService.getQuestion(id))
                            .build());
        }
        catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }
    }

    @QuesUpdateApiRequest
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateQues(@PathVariable("id") Long id, @RequestBody QuesUpdateDto quesUpdateDto){
        try{
            questionService.updateQuestion(id,quesUpdateDto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(questionService.getQuestion(id))
                            .build());
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }
    }

    @QuesDeleteApiRequest
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQues(@PathVariable("id")Long id){
        try{
            questionService.deleteQuestion(id);
            return ResponseEntity
                    .ok()
                    .body(new BaseResponse<>(HttpStatus.OK.value(),"질문이 삭제되었습니다."));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }
    }



}