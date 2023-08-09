package com.power.likelion.utils.swagger.AiInfo;


import com.power.likelion.dto.ai_info.AiInfoReqDto;
import com.power.likelion.dto.board.BoardReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Ai 소개글 생성", description = "Ai 소개글을 생성합니다," +
        "\n\n 제목, 내용, 이미지 url list를 함께 보내주면 됩니다." +
        "\n\n 주의할 점은 일반 회원으로 로그인한 경우 이용할 수 없다는 점입니다. 꼭 admin 계정을 생성하여 api를 테스트 해주세요")
@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "회원 정보", required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = AiInfoReqDto.class)))
public @interface CreateAiInfoApiReq {
}
