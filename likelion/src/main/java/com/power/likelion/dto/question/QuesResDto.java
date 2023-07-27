package com.power.likelion.dto.question;

import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.question.Question;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuesResDto {
    private Long questionId;
    private String title;
    private String content;
    private int point;
    private String questionCheck;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String nickname;

    @Builder
    public QuesResDto(Question question) {
        this.questionId=question.getId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.point = question.getPoint();
        this.questionCheck = question.getQuestionCheck().getDescription();
        this.viewCount = question.getViewCount();
        this.createdAt = question.getCreatedAt();
        this.modifiedAt = question.getModifiedAt();
        this.nickname=question.getMember().getNickname();
    }
}
