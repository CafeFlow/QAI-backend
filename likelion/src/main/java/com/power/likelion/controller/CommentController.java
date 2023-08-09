package com.power.likelion.controller;


import com.power.likelion.common.exception.AuthorMismatchException;
import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.service.CommentService;
import com.power.likelion.utils.swagger.comment.CommentCreateApiReq;
import com.power.likelion.utils.swagger.comment.CommentDeleteApiReq;
import com.power.likelion.utils.swagger.comment.CommentUpdateApiReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글 생성, 수정, 삭제", description = "댓글을 생성하고 생성한 댓글을 수정하고 삭제한다.")
@RequestMapping("/boards")
public class CommentController {

    private final CommentService commentService;

    @CommentCreateApiReq
    @PostMapping("/comment/{id}")
    public ResponseEntity<?> createAnswer(@PathVariable("id")Long id, @RequestBody AnswerReqDto answerReqDto){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(commentService.createComment(id, answerReqDto))
                            .build());
        }
        catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
        }
    }

    @CommentUpdateApiReq
    @PatchMapping("/comment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id, @RequestBody AnswerReqDto answerReqDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(commentService.updateComment(id,answerReqDto))
                            .build());

        }
        catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
        }
        catch(AuthorMismatchException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }

    }

    @CommentDeleteApiReq
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        try{
            commentService.deleteComment(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(null)
                            .build());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
        }

    }


}
