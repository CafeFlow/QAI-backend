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

        @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\"message\": \"요청에 성공하였습니다.\"," +
                                                "\"code\": 200," +
                                                "\"data\": {" +
                                                "\"boardId\": 1," +
                                                "\"title\": \"참치김치시금치\"," +
                                                "\"content\": \"콩나물물물\"," +
                                                "\"boardType\": \"자유 게시판\"," +
                                                "\"createdBy\": \"안땡땡\"," +
                                                "\"viewCount\": 0," +
                                                "\"createdAt\": \"2023-08-02T01:07:30.8376252\"," +
                                                "\"modifiedAt\": \"2023-08-02T01:07:30.8376252\"," +
                                                "\"comments\": null" +
                                                "}" +
                                                "}",
                                        summary = "요청에 성공한 경우의 예제입니다.",
                                        description = "요청에 성공한 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "500", description = "유저가 존재하지 않습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "실패 예제1", value = "{\"status\": \"500\", \"message\": \"유저가 존재하지 않습니다.\", \"data\": null}",
                                        summary = "유저 존재 x", description = "유저가 존재하지 않을 때 에러 입니다.")

                        }))
})
public @interface BoardCreateApiRes {

}

