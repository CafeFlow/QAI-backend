package com.power.likelion.utils.oauth2.oauthrequest;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NaverReq {
    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    String naverClientId;

    @Value("${spring.security.oauth2.client.registration.naver.redirect-uri}")
    String naverRedirect;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    String naverClientSecret;

}
