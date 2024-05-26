package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.LoginMember;
import com.team1060.golf.dao.RegisterMember;
import com.team1060.golf.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> loginMember(@RequestBody LoginMember member){
        memberService.loginMember(member);
        return ResponseEntity.ok("로그인 완료");
    }
}
