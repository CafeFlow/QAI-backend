package com.power.likelion.dto.login;

import com.power.likelion.common.response.SignStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetInfoRes {
    private SignStatus status;
    private String message;
    private String email;
    private String nickname;
    private int age;


    @Builder
    public GetInfoRes(SignStatus status, String message, String email, String nickname, int age) {
        this.status = status;
        this.message = message;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
    }


}
