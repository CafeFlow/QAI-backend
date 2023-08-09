package com.power.likelion.utils.swagger.board;

import com.power.likelion.dto.board.BoardReqDto;
import com.power.likelion.dto.board.BoardUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "게시글 수정", description = "게시글 유형, 게시글 내용, 게시글 제목을 수정합니다.")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "수정할 내용", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = BoardUpdateDto.class)))
public @interface BoardUpdateApiReq {
}
