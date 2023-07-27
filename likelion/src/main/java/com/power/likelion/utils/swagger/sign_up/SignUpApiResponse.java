package com.power.likelion.utils.swagger.sign_up;

import com.power.likelion.dto.sign_up.SingUpResDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "회원가입에 성공하였습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\"status\": \"OK\", \"message\": \"회원가입에 성공하였습니다.\", \"data\": \"example@example.com\"}",
                                        summary = "회원가입 성공 예제", description = "회원가입에 성공한 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "409", description = "이미 존재하는 이메일 입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SingUpResDto.class),
                        examples = {
                                @ExampleObject(name = "실패 예제", value = "{\"status\": \"EXIST_EMAIL\", \"message\": \"이미 존재하는 이메일 입니다.\", \"data\": null}",
                                        summary = "회원가입 실패 예제", description = "이미 존재하는 이메일로 회원가입이 실패한 경우의 예제입니다.")
                        }))
})
public @interface SignUpApiResponse {
}
