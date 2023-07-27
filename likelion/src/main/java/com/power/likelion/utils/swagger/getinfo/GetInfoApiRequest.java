package com.power.likelion.utils.swagger.getinfo;


import com.power.likelion.dto.login.GetInfoRes;
import com.power.likelion.dto.login.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "내 정보 조회", description = "헤더의 토큰과 이메일 기반으로 내 정보를 조회합니다.")
@Parameter(name = "email", description = "이메일 주소", required = true)
public @interface GetInfoApiRequest {
}
