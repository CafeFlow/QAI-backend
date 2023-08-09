package com.power.likelion.dto.board;

import com.power.likelion.dto.question.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BoardPageResDto {
    private PageInfo pageInfo;
    private List<BoardResDto> boardList;
}
