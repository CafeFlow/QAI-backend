package com.power.likelion.utils.swagger.answer;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.LocalDateTime;

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
                                                "        \"id\": 1,\n" +
                                                "        \"content\": \"네이버 신도 존재해요\",\n" +
                                                "        \"answerCheck\": \"채택\",\n" +
                                                "        \"questionCheck\": \"채택\",\n" +
                                                "        \"createdBy\": \"김땡땡\",\n" +
                                                "        \"createdAt\": \"2023-08-09T16:22:51.988461\",\n" +
                                                "        \"modifiedAt\": \"2023-08-09T16:22:51.988461\"\n" +
                                                "    }\n" +
                                                "}",
                                        summary = "API 성공 예제", description = "요청에 성공한 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "500", description = "총 4가지가 존재합니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "에러 예제1",
                                        value = "{\n" +
                                                "    \"message\": \"해당 질문 작성자가 아닙니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "동일한 작성자 x",
                                        description = "해당 질문 작성자가 아닐 경우의 예제입니다."),
                                @ExampleObject(name = "에러 예제2",
                                        value = "{\n" +
                                                "    \"message\": \"자신의 답변은 채택 불가능 합니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "자문자답 x",
                                        description = "자신의 답변은 채택할 수 없는 경우의 예제입니다."),
                                @ExampleObject(name = "에러 예제3",
                                        value = "{\n" +
                                                "    \"message\": \"이미 해당 질문은 채택 되었습니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "이미 질문이 채택 된 상태면 채택 수정 불가능",
                                        description = "이미 질문이 채택되었을 경우의 예제입니다."),
                                @ExampleObject(name = "에러 예제4",
                                        value = "{\n" +
                                                "    \"message\": \"질문or작성자or답변 이 존재하지 않습니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "해당 요소들이 존재하지 않을 경우",
                                        description = "해당 요소들이 존재하지 않을 경우의 예제입니다.")
                        }))
})
public @interface CheckAnswerApiRes {
}
