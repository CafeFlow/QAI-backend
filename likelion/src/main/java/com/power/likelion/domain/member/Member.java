package com.power.likelion.domain.member;

import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.domain.question.Answer;
import com.power.likelion.domain.question.Question;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="member")
@Builder
@AllArgsConstructor
public class Member extends AuditingFiled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 10)
    private String nickname;

    @Column(nullable = false)
    private int age;

    @Column(nullable=false, length=50)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<Question>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers=new ArrayList<Answer>();

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();

    public void setRoles(List<Authority> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }


}
