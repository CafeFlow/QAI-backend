package com.power.likelion.dto.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardUpdateDto {
    @Schema(example = "게장간장된장국간장")
    String title;

    @Schema(example = "배포는 짜증나")
    String content;
}
