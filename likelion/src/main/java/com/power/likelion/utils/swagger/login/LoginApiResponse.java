package com.power.likelion.utils.swagger.login;


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
        @ApiResponse(responseCode = "200", description = "로그인 성공.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\"status\": \"OK\"," +
                                                " \"message\": \"로그인 성공.\"," +
                                                "\"name\": \"김무한\"," +
                                                "\"email\": \"exmaple@example.com\","+
                                                "\"age\": \"30\","+
                                                "\"jwtToken\": \"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJyb2xlcyI6W3sibmFtZSI6IlVTRVIifV0sImlhdCI6MTY4OTQxODEzNywiZXhwIjoxNjg5NDIxNzM3fQ.LwH72CZq34PNsU6xgX_ph_T7M3PTomAbw1eogSGNjvs\"}",
                                        summary = "로그인 성공 예제", description = "로그인에 성공한 경우의 예제입니다.")
                        })),
        @ApiResponse(responseCode = "404", description = "비밀번호가 틀립니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "실패 예제1", value = "{\"status\": \"LOGIN_FAILED\", \"message\": \"비밀번호가 틀립니다.\", \"jwtToken\": null}",
                                        summary = "비밀번호 틀림", description = "비밀번호가 틀린 경우의 예제입니다."),
                                @ExampleObject(name = "실패 예제2", value = "{\"status\": \"LOGIN_FAILED\", \"message\": \"이메일이 존재하지 않습니다.\", \"jwtToken\": null}",
                                        summary = "이메일 없음", description = "이메일이 존재하지 않을 경우의 예제입니다.")
                        }))
})
public @interface LoginApiResponse {

}
