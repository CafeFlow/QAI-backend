package com.power.likelion.domain.ai_info;

import com.power.likelion.common.entity.AuditingFiled;
import com.power.likelion.domain.image.Image;
import com.power.likelion.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class AiInfo extends AuditingFiled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 10000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId")
    private Member member;

    @OneToMany(mappedBy="aiInfo")
    private List<Image> image = new ArrayList<Image>();

    @Builder
    public AiInfo(Long id, String title, String content, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void setImage(List<Image> images){
        this.image=images;
    }
}
