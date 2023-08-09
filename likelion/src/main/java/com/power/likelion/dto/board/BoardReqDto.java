package com.power.likelion.dto.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardReqDto {

    @Schema(example = "참치김치시금치")
    private String title;

    @Schema(example="콩나물물물")
    private String content;


}
