package com.power.likelion.utils.swagger.sign_up;

import com.power.likelion.dto.sign_up.SignUpReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "회원가입", description = "파라미터로 받은 데이터를 이용하여 회원가입을 진행합니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "회원 정보", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = SignUpReqDto.class)))
public @interface SignUpApiRequest {
}
