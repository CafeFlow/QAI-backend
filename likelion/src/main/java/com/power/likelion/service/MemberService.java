package com.power.likelion.service;

import com.power.likelion.common.response.SignStatus;
import com.power.likelion.domain.member.Authority;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.login.GetInfoRes;
import com.power.likelion.dto.login.LoginDto;
import com.power.likelion.dto.login.LoginResDto;
import com.power.likelion.dto.sign_up.SignUpReqDto;
import com.power.likelion.repository.MemberRepository;
import com.power.likelion.utils.jwts.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public void createMember(SignUpReqDto signUpReqDto) throws IllegalAccessException{


        Optional<Member> optionalUser = memberRepository.findByEmail(signUpReqDto.getEmail());
        if(optionalUser.isPresent()){
            throw new IllegalAccessException("이미 존재하는 이메일 입니다.");
        }

        Member member = Member.builder()
                .email(signUpReqDto.getEmail())
                .password(encoder.encode(signUpReqDto.getPassword()))
                .nickname(signUpReqDto.getNickname())
                .age(signUpReqDto.getAge())
                .point(100)
                .build();

        member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

        try{
            memberRepository.save(member);
        }
        catch(Exception e){
            throw new IllegalAccessException("데이터 베이스 삽입 오류 입니다");
        }
    }


    /** 먼저 db에서 해당 이메일을 찾는다. */
    public LoginResDto login(LoginDto loginDto) throws Exception {
        Member member=memberRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(()->new Exception("이메일이 존재하지 않습니다."));

        if(!encoder.matches(loginDto.getPassword(),member.getPassword())){
            throw new Exception("비밀번호가 틀립니다.");
        };
        /** jwt 토큰과 함께 loginResDto 전달하기 */
        return LoginResDto.builder()
                .message("로그인 성공")
                .status(SignStatus.OK)
                .nickname(member.getNickname())
                .email(member.getEmail())
                .age(member.getAge())
                .jwtToken(jwtProvider.createToken(member.getEmail(), member.getRoles()))
                .point(member.getPoint())
                .build();
    }

    public GetInfoRes getMember(String email) throws Exception {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return GetInfoRes.builder()
                .message("요청된 정보입니다.")
                .status(SignStatus.OK)
                .nickname(member.getNickname())
                .email(member.getEmail())
                .age(member.getAge())
                .point(member.getPoint())
                .build();
    }

    @Transactional
    public void createAdmin(SignUpReqDto signUpReqDto) throws IllegalAccessException{


        Optional<Member> optionalUser = memberRepository.findByEmail(signUpReqDto.getEmail());
        if(optionalUser.isPresent()){
            throw new IllegalAccessException("이미 존재하는 admin 입니다.");
        }

        Member member = Member.builder()
                .email(signUpReqDto.getEmail())
                .password(encoder.encode(signUpReqDto.getPassword()))
                .nickname(signUpReqDto.getNickname())
                .age(signUpReqDto.getAge())
                .build();
        member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_ADMIN").build()));

        try{
            memberRepository.save(member);
        }
        catch(Exception e){
            throw new IllegalAccessException("데이터 베이스 삽입 오류 입니다");
        }
    }
}
