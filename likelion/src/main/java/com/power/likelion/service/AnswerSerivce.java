package com.power.likelion.service;

import com.power.likelion.common.entity.CheckStatus;
import com.power.likelion.domain.member.Member;
import com.power.likelion.domain.question.Answer;
import com.power.likelion.domain.question.Question;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.dto.question.AnswerResDto;
import com.power.likelion.repository.AnswerRepository;
import com.power.likelion.repository.MemberRepository;
import com.power.likelion.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerSerivce {

    private final MemberRepository memberRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @Transactional
    public AnswerResDto createAnswer(Long id, AnswerReqDto answerReqDto)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName(); /** 이메일이 들어감 */

        Member member=memberRepository.findByEmail(name)
                .orElseThrow(()->new Exception("유저가 존재하지 않습니다."));
        Question question=questionRepository.findById(id)
                .orElseThrow(()->new Exception("게시글이 존재하지 않습니다."));

        //일단 댓글 정보를 Entity로 바꿔야함
        Answer answer=Answer.builder()
                .answerCheck(CheckStatus.False)
                .content(answerReqDto.getContent())
                .member(member)
                .question(question)
                .build();

        return AnswerResDto.builder()
                .answer(answerRepository.save(answer))
                .build();

    }
    @Transactional(readOnly = true)
    public List<AnswerResDto> getAnswers(Long id) {
        List<Answer> answers = answerRepository.findByQuestionId(id);
        List<AnswerResDto> answerResDtos=new ArrayList<>();
        answers.forEach(o -> answerResDtos.add(new AnswerResDto(o)));
        return answerResDtos;
    }

}
