package com.power.likelion.dto.sign_up;


import com.power.likelion.common.response.SignStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SingUpResDto {
    private SignStatus status;
    private String message;
    private Object data;

    @Builder
    public SingUpResDto(SignStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
