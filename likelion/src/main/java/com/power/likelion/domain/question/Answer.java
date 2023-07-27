package com.power.likelion.domain.question;


import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends AuditingFiled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false,columnDefinition = "integer default 0") // 0이면 채택전 1이면 채택후
    private int answerCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @OnDelete(action = OnDeleteAction.CASCADE) // 연관된 user가 삭제되면 같이 삭제됨
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;
}
