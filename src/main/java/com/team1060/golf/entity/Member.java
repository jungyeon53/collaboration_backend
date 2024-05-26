package com.team1060.golf.entity;

import com.team1060.golf.enums.AuthDate;
import com.team1060.golf.enums.AuthType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo; // 회원번호

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
}
