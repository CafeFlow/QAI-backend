package com.power.likelion.domain.board;

import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.question.AnswerReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends AuditingFiled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    @Builder
    public Comment(String content, Member member, Board board) {
        this.content = content;
        this.member = member;
        this.board = board;
    }

    public void update(AnswerReqDto answerReqDto){
        this.content=answerReqDto.getContent();
    }
}
