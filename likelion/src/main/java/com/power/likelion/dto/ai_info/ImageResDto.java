package com.power.likelion.dto.ai_info;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ImageResDto {
    private String imageUrl;

    @Builder
    public ImageResDto(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
