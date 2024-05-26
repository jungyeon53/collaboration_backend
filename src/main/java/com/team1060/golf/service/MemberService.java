package com.team1060.golf.service;

import com.team1060.golf.dao.LoginMember;
import com.team1060.golf.dao.RegisterMember;
import com.team1060.golf.entity.Member;
import com.team1060.golf.exception.DuplicateEmailException;
import com.team1060.golf.exception.DuplicateNickNameException;
import com.team1060.golf.mapMapper.MemberMapper;
import com.team1060.golf.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    /**
     * 회원가입
     * @param member
     */
    public void registerMember(RegisterMember member){
        validateEmail(member.getEmail());
        validateNickName(member.getNickname());
        memberRepository.save(RegisterMember.insertMember(member));
    }

    /**
     * 이메일 중복검사
     * @param Email
     */
    public void validateEmail(String Email){
        boolean isValidateEmail = memberRepository.existsByEmail(Email);
        if(isValidateEmail){
            throw new DuplicateEmailException("이미 가입된 이메일입니다.");
        }
    }

    /**
     * 닉네임 중복검사
     * @param nickName
     */
    public void validateNickName(String nickName){
        boolean isValidateNickname = memberRepository.existsByNickname(nickName);
        if(isValidateNickname){
            throw new DuplicateNickNameException("이미 가입된 닉네임입니다.");
        }
    }

    /**
     * 로그인
     * @param loginMember
     */
    public void loginMember(LoginMember loginMember) {
        Member member = memberRepository.findByEmail(loginMember.getEmail()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));
        boolean isPassword = member.getPassword().equals(loginMember.getPassword());
        if(!isPassword){
            throw new IllegalArgumentException("비밀번호가 틀립니다.");
        }
    }
}
