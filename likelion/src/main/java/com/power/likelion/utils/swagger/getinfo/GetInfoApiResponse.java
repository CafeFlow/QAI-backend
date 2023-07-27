package com.power.likelion.utils.swagger.getinfo;

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
        @ApiResponse(responseCode = "200", description = "내 정보 조회에 성공한 예시입니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "성공 예제",
                                        value = "{\"status\": \"OK\", \"message\": \"요청된 정보입니다.\",\"email\": \"email@email.com\",\"name\": \"김무한\", \"age\": \"30\"}",
                                        summary = "내 정보 조회 성공 예제", description = "내 정보 조회에 성공하였습니다.")
                        }))
})
public @interface GetInfoApiResponse {
}
