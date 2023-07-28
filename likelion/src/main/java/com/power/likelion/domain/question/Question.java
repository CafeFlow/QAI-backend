package com.power.likelion.domain.question;

import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.question.QuesUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Question extends AuditingFiled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false ,length = 10000)
    private String content;

    @Column(nullable =false)
    private int point;

    @Column( nullable = false,columnDefinition = "integer default 0")
    private int viewCount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="memberId")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CheckStatus questionCheck;


    @OneToMany(mappedBy = "question")
    private List<Answer> answers=new ArrayList<Answer>();

    public void setAnswers(List<Answer> answers){
        this.answers.clear();
        this.answers.addAll(answers);
    }

    public void update(QuesUpdateDto quesUpdateDto){
        this.title=quesUpdateDto.getTitle();
        this.content=quesUpdateDto.getContent();
        this.point=quesUpdateDto.getPoint();
    }

}
