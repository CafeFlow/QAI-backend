package com.power.likelion.domain.image;

import com.power.likelion.domain.ai_info.AiInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 500)
    private String url;


    @ManyToOne
    @JoinColumn(name="aiinfoId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AiInfo aiInfo;

    public Image(String url){
        this.url = url;
    }
    public Image(String url, AiInfo aiInfo) {
        this.url = url;
        this.aiInfo = aiInfo;
    }
}
