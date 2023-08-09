package com.power.likelion.utils.swagger.board;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "단일 게시글 조회", description = "게시글 id로 단일 게시글을 조회합니다." +
        "\n\n 게시글 번호를 넘겨주면 해당 게시글 정보가 Response로 제공됩니다.")
public @interface BoardGetApiReq {
}
