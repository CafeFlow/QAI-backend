package com.power.likelion.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class BaseResponse<T> {

    private String message;
    private int code;
    private T data;

    /** 요청 성공 시 */
    @Builder
    public BaseResponse(T result) {
        this.message = "요청에 성공하였습니다." ;
        this.code = HttpStatus.OK.value();
        this.data = result;
    }


    /** 직접 설정 */

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}