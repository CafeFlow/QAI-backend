package com.power.likelion.utils.swagger.question;



import com.power.likelion.dto.question.QuesReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "질문 생성", description = "제목, 내용, 내공을 입력하면 질문을 생성합니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "작성 예시", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = QuesReqDto.class)))
public @interface QuesApiRequest {
}
