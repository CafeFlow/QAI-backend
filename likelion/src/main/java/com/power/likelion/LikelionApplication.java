package com.power.likelion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LikelionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikelionApplication.class, args);
	}

}

//TODO: 2023-07-28 현재 BaseResponse를 만들고 login, sign-up, get-info, createQuestion, getAllQuestion은 사용 안함
//TODO: 			나중에 수정해줘야함.

