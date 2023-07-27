package com.power.likelion.utils.swagger.question;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "페이지 번호를 입력하면 해당 페이지의 10개의 게시글이 나옴", description = "0번부터 시작되니 처음에 조회시 0번부터 조회")
public @interface GetAllQuesRequest {
}
