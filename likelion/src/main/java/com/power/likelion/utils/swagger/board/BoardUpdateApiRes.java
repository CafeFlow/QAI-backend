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
        @ApiResponse(responseCode = "200", description = "게시글 수정에 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\n" +
                                                "    \"message\": \"요청에 성공하였습니다.\",\n" +
                                                "    \"code\": 200,\n" +
                                                "    \"data\": {\n" +
                                                "        \"boardId\": 2,\n" +
                                                "        \"title\": \"리액트 액션 빔\",\n" +
                                                "        \"content\": \"짱맨\",\n" +
                                                "        \"boardType\": \"비밀 게시판\",\n" +
                                                "        \"createdBy\": \"안땡땡\",\n" +
                                                "        \"viewCount\": 0,\n" +
                                                "        \"createdAt\": \"2023-08-03T01:54:09.417754\",\n" +
                                                "        \"modifiedAt\": \"2023-08-03T01:54:09.417754\",\n" +
                                                "        \"comments\": null\n" +
                                                "    }\n" +
                                                "}",
                                        summary = "성공 예제",
                                        description = "요청에 성공한 경우의 응답 예제입니다.")
                        })),
        @ApiResponse(responseCode = "500", description = "게시글이 존재하지 않거나 작성자가 동일하지 않을경우 에러가 발생합니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "에러 예제1",
                                        value = "{\n" +
                                                "    \"message\": \"동일한 작성자가 아닙니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "동일한 작성자 x",
                                        description = "동일한 작성자가 아닐 경우의 예제입니다."),
                                @ExampleObject(name = "에러 예제2",
                                        value = "{\n" +
                                                "    \"message\": \"게시글이 존재하지 않습니다.\",\n" +
                                                "    \"code\": 500,\n" +
                                                "    \"data\": null\n" +
                                                "}",
                                        summary = "게시글 존재 x",
                                        description = "게시글이 존재하지 않을 경우의 예제입니다.")
                        }))
})
public @interface BoardUpdateApiRes {
}
