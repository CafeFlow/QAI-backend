package com.power.likelion.utils.swagger.board;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "게시글 삭제", description = "커뮤니티 게시글을 삭제합니다." +
        "\n\n 게시글 번호를 넘겨주면 해당 게시글이 삭제됩니다.")
public @interface BoardDeleteApiReq {
}
