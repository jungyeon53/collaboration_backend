package com.team1060.golf.reposigory;

import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void delete(){
        Optional<Member> member = memberRepository.findByEmail("jung");
        memberRepository.deleteById(member.get().getUserNo());
    }

    @Test
    public void 회원가입_조회(){
        // given
        String email = "jung";
        String nickname = "정연";
        String password = "1234";
        String phone_number = "01012341234";
        boolean is_sms_consent = true;
        boolean is_email_consent = true;

        memberRepository.save(
                Member.builder()
                        .email(email)
                        .password(password)
                        .nickname(nickname)
                        .phone_number(phone_number)
                        .is_sms_consent(is_sms_consent)
                        .is_email_consent(is_email_consent)
                        .build()
        );
        // when
        Optional<Member> member = memberRepository.findByEmail(email);

        // then
        assertThat(member.get().getEmail()).isEqualTo("jung");
        assertThat(member.get().getNickname()).isEqualTo(nickname);
    }



}
