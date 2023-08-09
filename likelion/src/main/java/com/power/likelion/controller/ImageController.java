package com.power.likelion.controller;

import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.ai_info.ImageResDto;
import com.power.likelion.utils.s3.S3Uploader;
import com.power.likelion.utils.swagger.Image.ImageUploadApiRes;
import com.power.likelion.utils.swagger.Image.ImageUploadApiReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "이미지 업로드,삭제,조회", description = "이미지 하나를 업로드 시키면 해당 이미지 url을 얻을 수 있다.")
public class ImageController {

    private final S3Uploader s3Uploader;

    /** 해당 bucket의 aiinfo에 사진을 저장 */
    @ImageUploadApiReq
    @ImageUploadApiRes
    @PostMapping(value = "/upload/image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> uploadImage(@RequestParam(value = "image",required = false) MultipartFile files){
        try {
            ImageResDto imageResDto=s3Uploader.upload(files,"aiinfo");

            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(imageResDto)
                            .build());
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage()));

        }

    }
}
