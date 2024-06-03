package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.LoginMember;
import com.team1060.golf.dao.RegisterMember;
import com.team1060.golf.dao.ReissuanceToken;
import com.team1060.golf.dto.LoginDto;
import com.team1060.golf.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/")
public class MemberRestController {

    private final MemberService memberService;

    /**
     * 회원가입
     * @param member
     * @return
     */
    @PostMapping("insert")
    public ResponseEntity<String> registerMember(@RequestBody RegisterMember member){
        memberService.registerMember(member);
        return ResponseEntity.ok("회원 가입 완료");
    }

    /**
     * 로그인
     * @param member
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<LoginDto> loginMember(@RequestBody LoginMember member){
        LoginDto response = memberService.loginMember(member);
        return ResponseEntity.ok(response);
    }

    /**
     * refreshToken 재발급
     * @param token
     * @return
     */
    @PostMapping("refresh")
    public ResponseEntity<LoginDto> reissuanceRefreshToken(@RequestBody ReissuanceToken token){
        LoginDto response = memberService.reissuanceToken(token);
        return ResponseEntity.ok(response);
    }

    /**
     * 로그아웃
     * @param email
     */
    @PostMapping("logout")
    public void logout(@RequestParam String email){
        memberService.logout(email);
    }
}
