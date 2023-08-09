package com.power.likelion.dto.question;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class QuesPageResDto {
    private PageInfo pageInfo;
    private List<AllQuesResDto> questionList;
}
