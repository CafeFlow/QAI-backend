package com.power.likelion.dto.question;


import com.power.likelion.domain.question.Answer;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AnswerCheckResDto {
    private Long id;
    private String content;
    private String answerCheck;
    private String questionCheck;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    @Builder
    public AnswerCheckResDto(Answer answer) {
        this.id = answer.getId();
        this.content = answer.getContent();
        this.answerCheck = answer.getAnswerCheck().getDescription();
        this.createdBy = answer.getMember().getNickname();
        this.createdAt = answer.getCreatedAt();
        this.modifiedAt = answer.getModifiedAt();
        this.questionCheck=answer.getQuestion().getQuestionCheck().getDescription();
    }

}
