package com.power.likelion.dto.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuesReqDto {

    @Schema(description = "제목", example = "해커톤은 어떻게 진행되나요?")
    private String title;

    @Schema(description = "내용", example = "제목과 내용이 같습니다.")
    private String content;

    @Schema(description = "내공", example = "100")
    private int point;

    @Schema(description = "닉네임", example = "김부자")
    private String nickname;


    public QuesReqDto(String title, String content, int point, String nickname) {
        this.title = title;
        this.content = content;
        this.point = point;
        this.nickname = nickname;
    }
}
