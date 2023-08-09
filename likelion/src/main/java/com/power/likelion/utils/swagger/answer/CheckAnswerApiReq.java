package com.power.likelion.utils.swagger.answer;


import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "답변 채택", description = "해당 답변의 id를 넘겨주면 답변이 채택되며 질문이 채택 상태로 변화 합니다.")
public @interface CheckAnswerApiReq {
}
