package com.power.likelion.utils.swagger.login;

import com.power.likelion.dto.login.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "로그인", description = "이메일과 비밀번호를 입력하여 로그인을 진행합니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "회원 정보", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = LoginDto.class)))
public @interface LoginApiRequest {
}
