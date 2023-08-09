package com.power.likelion.utils.swagger.Image;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "이미지 업로드 성공 예시",
                                        value = "{\n" +
                                                "    \"message\": \"요청에 성공하였습니다.\",\n" +
                                                "    \"code\": 200,\n" +
                                                "    \"data\": {\n" +
                                                "        \"imageUrl\": \"https://ncp-bucket-user.kr.object.ncloudstorage.com/aiinfo/921193333073900.jpg\"\n" +
                                                "    }\n" +
                                                "}",
                                        summary = "이미지 업로드 성공 예시",
                                        description = "이미지 업로드에 성공한 예시 입니다.")
                        }))

})
public @interface ImageUploadApiRes {
}
