package com.power.likelion.utils.oauth2.userinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaverProfile {
    Response response;

    @Data
    public class Response{
        private String email;
        private String id;
        private String nickname;
    }
}
