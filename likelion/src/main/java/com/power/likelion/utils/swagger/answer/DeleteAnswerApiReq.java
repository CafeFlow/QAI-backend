package com.power.likelion.utils.swagger.answer;

import com.power.likelion.dto.question.AnswerReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "댓글 삭제", description = "댓글 id로 댓글을 삭제합니다.")
public @interface DeleteAnswerApiReq {
}
