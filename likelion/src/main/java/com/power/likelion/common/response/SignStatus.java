package com.power.likelion.common.response;

import org.springframework.http.HttpStatus;

public enum SignStatus {
    OK(HttpStatus.OK.value(),"OK"),
    EXIST_EMAIL(HttpStatus.CONFLICT.value(), "EXIST_EMAIL"),
    LOGIN_FAILED(HttpStatus.NOT_FOUND.value(),"LOGIN_FAILED")

    ;

    int statusCode;
    String code;

    SignStatus(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}
