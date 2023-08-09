package com.power.likelion.utils.swagger.Image;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "이미지 업로드", description = "이미지를 업로드 합니다." +
        "\n\n 서버에 설정을 jpeg파일과 png 파일만 업로드 가능하게 설정하여서 파일 확장자 명을 잘 보고 보내주시면 되겠습니다." +
        "\n\n 만약, 업로드가 성공하면 Response로 해당 이미지의 url이 갈것입니다. 이 url을 잘 저장했다가 Ai소개글 작성단계에서 글 생성시" +
        "같이 보내주시면 됩니다.")
public @interface ImageUploadApiReq {
}
