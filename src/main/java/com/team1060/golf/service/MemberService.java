package com.team1060.golf.service;

import com.team1060.golf.config.jwt.TokenProvider;
import com.team1060.golf.dao.LoginMember;
import com.team1060.golf.dao.RegisterMember;
import com.team1060.golf.dao.ReissuanceToken;
import com.team1060.golf.dto.LoginDto;
import com.team1060.golf.entity.Member;
import com.team1060.golf.exception.DuplicateEmailException;
import com.team1060.golf.exception.DuplicateNickNameException;
import com.team1060.golf.repository.MemberRepository;
import com.team1060.golf.utils.EntityFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private static final int DEFAULT_ACCESS_EXPIRATION_MINUTES = 30;
    private static final int DEFAULT_REFRESH_EXPIRATION_DAYS = 7;

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EntityFetcher entityFetcher;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;


    /**
     * 회원가입
     * @param member
     */
    public void registerMember(RegisterMember member){
        validateEmail(member.getEmail());
        validateNickName(member.getNickname());
        memberRepository.save(RegisterMember.insertMember(member, bCryptPasswordEncoder));
    }

    /**
     * 이메일 검사
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
    public LoginDto loginMember(LoginMember loginMember) {
        Member member = entityFetcher.selectMember(loginMember.getEmail());
        boolean isPassword = passwordEncoder.matches(loginMember.getPassword(), member.getPassword());
        if (!isPassword) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return makeRefreshToken(member);
    }

    /**
     * 토큰 생성
     * @param member
     * @param
     * @return
     */
    public LoginDto makeRefreshToken(Member member){
        String accessToken = null;
        String refreshToken = null;
        // acessToken
        Duration acessTime = Duration.ofMinutes(DEFAULT_ACCESS_EXPIRATION_MINUTES);
        accessToken = tokenProvider.makeToken(member, acessTime);
        // refreshToken
        Duration refreshTime = Duration.ofDays(DEFAULT_REFRESH_EXPIRATION_DAYS);
        refreshToken = tokenProvider.makeToken(member, refreshTime);
        saveRefreshToken(member, refreshToken);
        return new LoginDto(member.getEmail(), accessToken, refreshToken);
    }

    /**
     * refreshToken 저장
     * @param member
     * @param refreshToken
     * @return
     */
    public void saveRefreshToken(Member member ,String refreshToken){
        member.setRefreshToken(refreshToken);
        memberRepository.save(member);
    }

    /**
     * refreshToken 재발급
     * @param token
     * @return
     */
    public LoginDto reissuanceToken(ReissuanceToken token){
        Member member = entityFetcher.selectMember(token.getEmail());
        String preRefreshToken = member.getRefreshToken();
        boolean isRefreshTokenEquals = preRefreshToken.equals(token.getRefreshToken());
        if(!isRefreshTokenEquals){
            throw new IllegalArgumentException("토큰이 일치하지 않습니다.");
        }
        return makeRefreshToken(member);
    }

    /**
     * 로그아웃
     * @param email
     */
    public void logout(String email) {
        Member member = entityFetcher.selectMember(email);
        member.setRefreshToken(null);
        memberRepository.save(member);
    }
}
