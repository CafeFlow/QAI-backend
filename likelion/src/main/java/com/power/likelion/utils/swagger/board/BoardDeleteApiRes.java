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
        @ApiResponse(responseCode = "200", description = "질문이 삭제되었습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "삭제 성공 예제",
                                        value = "{\"message\": \"질문이 삭제되었습니다.\"," +
                                                "\"code\": 200," +
                                                "\"data\": null" +
                                                "}",
                                        summary = "질문 삭제 성공 예제",
                                        description = "질문이 성공적으로 삭제된 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "500", description = "게시글이 존재하지 않거나 게시글 작성자가 아닐경우 발생하는 에러코드입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "게시글 존재 X", value = "{\"status\": \"500\", \"message\": \"게시글이 존재하지 않습니다.\", \"data\": null}",
                                        summary = "게시글 존재 x", description = "게시글이 존재하지 않을때 Response 입니다."),
                                @ExampleObject(name = "게시글 작성지 X", value = "{\"status\": \"500\", \"message\": \"게시글 작성자가 아닙니다.\", \"data\": null}",
                                        summary = "게시글 작성자 x", description = "게시글 작성자가 아닐시의 Response 입니다.")

                        }))

})
public @interface BoardDeleteApiRes {
}
