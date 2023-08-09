package com.power.likelion.utils.swagger.OAuth2;


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
                                @ExampleObject(name = "성공 예제",
                                        value = "{\n" +
                                                "    \"message\": \"요청에 성공하였습니다.\",\n" +
                                                "    \"code\": 200,\n" +
                                                "    \"data\": {\n" +
                                                "        \"status\": \"OK\",\n" +
                                                "        \"message\": \"첫 소셜 로그인 입니다. 닉네임이 임의로 설정되어있으므로 수정 바랍니다. 나이 초기 설정 값은 NULL 입니다.\",\n" +
                                                "        \"nickname\": \"kakao1210083796485500\",\n" +
                                                "        \"email\": \"durri88888@naver.com\",\n" +
                                                "        \"age\": 0,\n" +
                                                "        \"jwtToken\": \"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdXJyaTg4ODg4QG5hdmVyLmNvbSIsInJvbGVzIjpbeyJuYW1lIjoiUk9MRV9VU0VSIn1dLCJpYXQiOjE2OTE1MTQ4MTksImV4cCI6MTY5MTUxODQxOX0.q4aqPS62MqYiDMhMUS6jd8QAAJTqc5ppDF0fsdKzwDU\",\n" +
                                                "        \"point\": 0\n" +
                                                "    }\n" +
                                                "}",
                                        summary = "API 성공 예제", description = "요청에 성공한 경우의 예제입니다.")
                        })),
})
public @interface OAuth2LoginApiRes {
}


