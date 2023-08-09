package com.power.likelion.utils.swagger.comment;

import com.power.likelion.dto.question.AnswerReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "댓글 삭제", description = "게시글에 댓글을 삭제합니다. 댓글 번호를 입력하면 됩니다.")
public @interface CommentDeleteApiReq {

}
