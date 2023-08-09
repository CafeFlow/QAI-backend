package com.power.likelion.controller;

import com.power.likelion.common.response.BaseResponse;
import com.power.likelion.dto.ai_info.AiInfoReqDto;
import com.power.likelion.service.AiInfoService;
import com.power.likelion.utils.swagger.AiInfo.CreateAiInfoApiReq;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "오픈 AI 소개 페이지", description = "AI를 소개하는 글을 admin 계정을 가진 회원만 작성할 수있다.")
public class AiInfoController {

    private final AiInfoService aiInfoService;
    /** 게시글 작성란 에서 작성을 누르면 오는 것 이미지는 게시글 작성란에서 업로드 버튼으로 미리 업로드 구현 */
    @CreateAiInfoApiReq
    @PostMapping("/ai-info/create")
    public ResponseEntity<?> createInfo(@RequestBody AiInfoReqDto aiInfoReqDto){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BaseResponse.builder()
                            .result(aiInfoService.createAiInfo(aiInfoReqDto))
                            .build());

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
        }
    }
}
