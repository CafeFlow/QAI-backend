package com.power.likelion.dto.ai_info;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AiInfoReqDto {

    @Schema(name = "title",example = "Ai 소개 게시글 입니다.")
    private String title;

    @Schema(name = "content",example = "chat gpt는 신이에요")
    private String content;

    @Schema(name = "url",example = "[\n" +
            "       \"https://ncp-bucket-user.kr.object.ncloudstorage.com/aiinfo/921056805240900.jpg\",\n" +
            "       \"https://ncp-bucket-user.kr.object.ncloudstorage.com/aiinfo/921193333073900.jpg\"\n" +
            "\n" +
            "  ]")
    private List<String> url;


}
