package com.power.likelion.dto.question;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AnswerReqDto {

    @Schema(example = "이빨 빠진 호랑이")
    private String content;
}
