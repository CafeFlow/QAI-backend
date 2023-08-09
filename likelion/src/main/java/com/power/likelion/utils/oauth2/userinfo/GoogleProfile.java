package com.power.likelion.utils.oauth2.userinfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleProfile {
    private String sub;
    private String email;
}
