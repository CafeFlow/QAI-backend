package com.power.likelion.utils.swagger.answer;


import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.dto.question.QuesReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "답변 생성", description = "입력받은 데이터로 해당 게시글의 답변을 생성합니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "작성 예시", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = AnswerReqDto.class)))
public @interface CreateAnswerApiReq {
}
