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
        @ApiResponse(responseCode = "200", description = "page를 0 size를 3으로 두었을 때 현재 게시글 개수가 4개인 경우를 예시로 들었습니다." +
                "\n\n 이런 상황에서 pageInfo는 현재 4개의 게시글을 3개씩 묶었을떄 총 2개의 페이지가 나온다는 소리를 숫자로 표시한 것입니다." +
                "\n\n page=현재 페이지 번호, pageSize는 3 totalQuestionNumber는 총 게시물 개수, totalPages는 총 페이지 개수입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\"message\": \"요청에 성공하였습니다.\"," +
                                                "\"code\": 200," +
                                                "\"data\": {" +
                                                "\"pageInfo\": {" +
                                                "\"page\": 0," +
                                                "\"pageSize\": 3," +
                                                "\"totalQuestionNumber\": 4," +
                                                "\"totalPages\": 2" +
                                                "}," +
                                                "\"boardList\": [" +
                                                "{" +
                                                "\"boardId\": 1," +
                                                "\"title\": \"스프링부트 너무 어려워요\"," +
                                                "\"content\": \"어떻게 공부를 시작해야 할까요?\"," +
                                                "\"boardType\": \"자유 게시판\"," +
                                                "\"createdBy\": \"안땡땡\"," +
                                                "\"viewCount\": 0," +
                                                "\"createdAt\": \"2023-08-02T02:43:30.703096\"," +
                                                "\"modifiedAt\": \"2023-08-02T02:43:30.703096\"," +
                                                "\"comments\": null" +
                                                "}," +
                                                "{" +
                                                "\"boardId\": 2," +
                                                "\"title\": \"스프링부트 너무 어려워요\"," +
                                                "\"content\": \"어떻게 공부를 시작해야 할까요?\"," +
                                                "\"boardType\": \"자유 게시판\"," +
                                                "\"createdBy\": \"안땡땡\"," +
                                                "\"viewCount\": 0," +
                                                "\"createdAt\": \"2023-08-02T02:43:31.306321\"," +
                                                "\"modifiedAt\": \"2023-08-02T02:43:31.306321\"," +
                                                "\"comments\": null" +
                                                "}," +
                                                "{" +
                                                "\"boardId\": 3," +
                                                "\"title\": \"스프링부트 너무 어려워요\"," +
                                                "\"content\": \"어떻게 공부를 시작해야 할까요?\"," +
                                                "\"boardType\": \"자유 게시판\"," +
                                                "\"createdBy\": \"안땡땡\"," +
                                                "\"viewCount\": 0," +
                                                "\"createdAt\": \"2023-08-02T02:43:31.874015\"," +
                                                "\"modifiedAt\": \"2023-08-02T02:43:31.874015\"," +
                                                "\"comments\": null" +
                                                "}" +
                                                "]" +
                                                "}" +
                                                "}",
                                        summary = "요청에 성공한 경우의 예제입니다.",
                                        description = "요청에 성공한 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "400", description = "입력이 잘못되었습니다. 입력을 제대로 해주세요",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "입력 오류", value = "{\"status\": \"400\", \"message\": \"입력이 잘못되었습니다.\", \"data\": null}",
                                        summary = "입력 오류", description = "입력이 잘못되었을 경우의 Response 입니다.")

                        }))

})

public @interface BoardPageApiRes {
}
