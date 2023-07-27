package com.power.likelion.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CheckStatus {
    True("채택"),
    False("채택전"),
    ;

    private String description;
}
