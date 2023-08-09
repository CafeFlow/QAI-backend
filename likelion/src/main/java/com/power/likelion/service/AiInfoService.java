package com.power.likelion.service;

import com.power.likelion.domain.ai_info.AiInfo;
import com.power.likelion.domain.image.Image;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.ai_info.AiInfoReqDto;
import com.power.likelion.dto.ai_info.AiInfoResDto;
import com.power.likelion.dto.ai_info.ImageResDto;
import com.power.likelion.dto.board.BoardResDto;
import com.power.likelion.repository.AiInfoRepository;
import com.power.likelion.repository.ImageRepository;
import com.power.likelion.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AiInfoService {
    private final AiInfoRepository aiInfoRepository;
    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;
    public AiInfoResDto createAiInfo(AiInfoReqDto aiInfoReqDto)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Member member=memberRepository.findByEmail(name)
                .orElseThrow(()->new Exception("유저가 존재하지 않습니다."));

        AiInfo aiInfo=AiInfo.builder()
                .title(aiInfoReqDto.getTitle())
                .content(aiInfoReqDto.getContent())
                .member(member)
                .build();

        // 이미지를 먼저 Image 엔티티 리스트로 만들고
        List<Image> imageList=aiInfoReqDto.getUrl().stream().map(o->new Image(o,aiInfo)).collect(Collectors.toList());


        // AiInfo게시물을 저장한다.
        AiInfoResDto aiInfoResDto= AiInfoResDto.builder()
                .aiInfo(aiInfoRepository.save(aiInfo))
                .build();

        // 이후 저장한 내용을 바탕으로 이미지도 해당 게시물 아이디로 저장한다.
        imageList.forEach(o->imageRepository.save(o));

        // 해당 이미지들을 다시 Response로 보내주기위해 ImageResDto도 따로 만든다.
        List<ImageResDto> imageResDtos=imageList.stream().map(o->new ImageResDto(o.getUrl())).collect(Collectors.toList());

        //양방향 매핑을 위한 setImage
        aiInfo.setImage(imageList);


        // 위에서 이미 게시글 정보는 다담았으므로 이미지 리스트만 설정해주고 Response를 return해주면 됨.
        aiInfoResDto.setImageList(imageResDtos);

        return aiInfoResDto;

    }
}
