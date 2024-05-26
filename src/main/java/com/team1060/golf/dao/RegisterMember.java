package com.team1060.golf.dao;

import com.team1060.golf.enums.AuthDate;
import com.team1060.golf.enums.AuthType;
import com.team1060.golf.entity.Member;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterMember {

    private String email; // 이메일
    private String nickname; // 닉네임
    private String username; // 이름
    private String password; // 비밀번호
    private ZonedDateTime regdate; // 가입일
    private String phone_number; // 휴대폰 번호
    @Enumerated(EnumType.STRING)
    private AuthType type;
    @Enumerated(EnumType.STRING)
    private AuthDate authDate; // 카카오인증, 메일인증, 휴대폰 인증 등 인증 정보
    private boolean is_sms_consent; // true 1 , false 0
    private boolean is_email_consent; // true 1 , false 0

    public static Member insertMember(RegisterMember member){
        return Member.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .username(member.getUsername())
                .regdate(ZonedDateTime.now())
                .phone_number(member.getPhone_number())
                .type(AuthType.CUSTOMER)
                .authDate(AuthDate.GOLF)
                .is_sms_consent(member.is_sms_consent())
                .is_email_consent(member.is_email_consent)
                .build();
    }

}
