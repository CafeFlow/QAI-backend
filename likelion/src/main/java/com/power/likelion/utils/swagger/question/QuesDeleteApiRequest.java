package com.power.likelion.utils.swagger.question;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "질문 삭제", description = "주어진 게시글을 게시글에 존재하는 댓글과 함께 삭제합니다.")
public @interface QuesDeleteApiRequest {
}
