package com.power.likelion.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class LoginDto {

    @Schema(description = "이메일", example = "example@example.com")
    private String email;

    @Schema(description = "비밀번호", example = "1234")
    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
