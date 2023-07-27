package com.power.likelion.service;


import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.member.Member;
import com.power.likelion.domain.question.Question;
import com.power.likelion.dto.question.AllQuesResDto;
import com.power.likelion.dto.question.QuesReqDto;
import com.power.likelion.dto.question.QuesResDto;
import com.power.likelion.repository.MemberRepository;
import com.power.likelion.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    @Transactional
    public QuesResDto createQuestion(QuesReqDto quesReqDto)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Member member=memberRepository.findByEmail(name)
                .orElseThrow(()->new Exception("유저가 존재하지 않습니다."));

        Question question=Question.builder()
                .point(quesReqDto.getPoint())
                .title(quesReqDto.getTitle())
                .content(quesReqDto.getContent())
                .questionCheck(CheckStatus.False)
                .member(member)
                .build();


        Question resQuestion =questionRepository.save(question);

        return QuesResDto.builder()
                .question(resQuestion)
                .build();

    }

    /** 페이징 처리로 10개의 게시글이 간다. */
    @Transactional
    public List<AllQuesResDto> getQuestions(int page){
        Page<Question> boards = questionRepository.findAll(PageRequest.of(page, 10));

        List<AllQuesResDto> results = boards.getContent().stream().map(question -> new AllQuesResDto(question)
        ).collect(Collectors.toList());

        return results;

    }

    @Transactional
    public QuesResDto getQuestion(Long id)throws Exception{
        Question question=questionRepository.findById(id).orElseThrow(
                ()->new Exception("해당 게시글이 존재하지 않습니다.")
        );

        return QuesResDto.builder()
                .question(question)
                .build();

    }
}
