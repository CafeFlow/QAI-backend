package com.power.likelion.dto.question;

import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.question.Answer;
import com.power.likelion.domain.question.Question;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private String createdBy;
    private List<AnswerResDto> answers;

    @Builder
    public QuesResDto(Question question) {
        this.questionId = question.getId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.point = question.getPoint();
        this.questionCheck = question.getQuestionCheck().getDescription();
        this.viewCount = question.getViewCount();
        this.createdAt = question.getCreatedAt();
        this.modifiedAt = question.getModifiedAt();
        this.createdBy = question.getMember().getNickname();
    }
    public void setAnswers(List<AnswerResDto> answer){
        this.answers=answer;
    }
}
