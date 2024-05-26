package com.team1060.golf.dto;

import com.team1060.golf.enums.AuthType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class MemberDto {

    private Long userNo; // 회원번호
    private String email; // 이메일
    private String nickname; // 닉네임
    private String username; // 이름
    private ZonedDateTime regdate; // 가입일
    private String phone_number; // 휴대폰 번호
    @Enumerated(EnumType.STRING)
    private AuthType type;
    private String auth_data; // 카카오인증, 메일인증, 휴대폰 인증 등 인증 정보
    private boolean is_sms_consent; // true 1 , false 0
    private boolean is_email_consent; // true 1 , false 0
}
