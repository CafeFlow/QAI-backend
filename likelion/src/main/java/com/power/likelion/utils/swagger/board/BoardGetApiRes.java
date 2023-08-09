package com.power.likelion.utils.swagger.board;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "단일 게시글 조회를 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\n" +
                                                "    \"message\": \"요청에 성공하였습니다.\",\n" +
                                                "    \"code\": 200,\n" +
                                                "    \"data\": {\n" +
                                                "        \"boardId\": 2,\n" +
                                                "        \"title\": \"게장간장된장국간장\",\n" +
                                                "        \"content\": \"배포는 무서워\",\n" +
                                                "        \"boardType\": \"자유 게시판\",\n" +
                                                "        \"createdBy\": \"안땡땡\",\n" +
                                                "        \"viewCount\": 0,\n" +
                                                "        \"createdAt\": \"2023-08-03T01:54:09.4177538\",\n" +
                                                "        \"modifiedAt\": \"2023-08-03T01:54:09.4177538\",\n" +
                                                "        \"comments\": null\n" +
                                                "    }\n" +
                                                "}",
                                        summary = "성공 예제",
                                        description = "요청에 성공한 경우의 응답 예제입니다.")
                        })),
        @ApiResponse(responseCode = "500", description = "요청에 실패하였을 경우 예제입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "에러 예제",
                                        value = "{\n" +
                                                "    \"message\": \"게시글이 존재하지 않습니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "에러 예제",
                                        description = "요청에 실패한 경우의 응답 예제입니다.")
                        }))
})
public @interface BoardGetApiRes {
}
