package com.power.likelion.utils.swagger.board;


import com.power.likelion.dto.board.BoardReqDto;
import com.power.likelion.dto.board.BoardResDto;
import com.power.likelion.dto.login.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "게시글 생성", description = "커뮤니티 게시글을 생성합니다." +
        "\n\n 제목, 내용, 게시판 유형을 입력하면 됩니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "회원 정보", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = BoardReqDto.class)))
public @interface BoardCreateApiReq {
}
