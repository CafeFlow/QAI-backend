package com.power.likelion.dto.ai_info;

import com.power.likelion.domain.ai_info.AiInfo;
import com.power.likelion.domain.image.Image;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AiInfoResDto {
    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<ImageResDto> imageList;

    @Builder
    public AiInfoResDto(AiInfo aiInfo) {
        this.id = aiInfo.getId();
        this.title = aiInfo.getTitle();
        this.content = aiInfo.getContent();
        this.createdAt=aiInfo.getCreatedAt();
        this.modifiedAt=aiInfo.getModifiedAt();
        this.createdBy = aiInfo.getMember().getNickname();
    }

    public void setImageList(List<ImageResDto> imageList){
        this.imageList=imageList;
    }
}
