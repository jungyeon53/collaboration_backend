package com.team1060.golf.service;

import com.team1060.golf.dao.RegisterMember;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void 회원가입_성공() {
        // given
        RegisterMember registerMember = RegisterMember.builder()
                .email("test2345")
                .nickname("test")
                .password("1234")
                .phone_number("010")
                .is_email_consent(true)
                .is_sms_consent(true)
                .build();

        // when
        memberService.registerMember(registerMember);

        // then
        ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);
        verify(memberRepository).save(memberCaptor.capture());
        Member savedMember = memberCaptor.getValue();

        assertThat(savedMember.getEmail()).isEqualTo(registerMember.getEmail());
        assertThat(savedMember.getNickname()).isEqualTo(registerMember.getNickname());
        assertThat(savedMember.getPassword()).isNotEqualTo(registerMember.getPassword());
        assertThat(savedMember.getPhone_number()).isEqualTo(registerMember.getPhone_number());
        assertThat(savedMember.is_email_consent()).isEqualTo(registerMember.is_email_consent());
        assertThat(savedMember.is_sms_consent()).isEqualTo(registerMember.is_sms_consent());
    }
}
