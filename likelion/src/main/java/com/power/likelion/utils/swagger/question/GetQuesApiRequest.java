package com.power.likelion.utils.swagger.question;


import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "단일 질문 조회", description = "요청한 질문과 질문에 달린 답변을 제공합니다.")
public @interface GetQuesApiRequest {
}
