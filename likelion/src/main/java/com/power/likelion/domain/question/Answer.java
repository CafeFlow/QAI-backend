package com.power.likelion.domain.question;


import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.question.AnswerReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Answer extends AuditingFiled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CheckStatus answerCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @OnDelete(action = OnDeleteAction.CASCADE) // 연관된 user가 삭제되면 같이 삭제됨
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;


    public void update(AnswerReqDto answerReqDto){
        this.content=answerReqDto.getContent();
    }
    public void changeCheck(){
        this.answerCheck=CheckStatus.True;
    }
}
