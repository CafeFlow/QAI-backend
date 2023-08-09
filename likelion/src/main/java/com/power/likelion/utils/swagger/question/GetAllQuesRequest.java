package com.power.likelion.utils.swagger.question;

import io.swagger.v3.oas.annotations.Operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "질문 조회, 검색",
        description = "페이지 번호(page)와 한 페이지에 몇개의 게시글이 나올지 size는 필수 값으로 입력해야된다." +
                "\n\n 나머지 두 입력값은 선택으로 필요할 경우 입력 하면 된다." +
                "\n\n option은 검색옵션으로 (제목), (내용), (제목+내용) 옵션만 검색기능이 있고 다른 옵션은 검색옵션이 나오지 않도록 설정하였다." +
                "\n\n searchKeyword는 검색할 내용으로 해당 내용으로 검색을 진행한다고 보면된다")
public @interface GetAllQuesRequest {

}
