package com.team1060.golf.utils;

import com.team1060.golf.entity.Category;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.CategoryRepository;
import com.team1060.golf.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityFetcher {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;


    /**
     * 카테고리 번호로 조회
     * @param categoryNo
     * @return
     */
    public Category selectCategory(Long categoryNo) {
        Category category = categoryRepository.findById(categoryNo)
                .orElseThrow(() -> new RuntimeException("해당 카테고리를 찾을 수 없습니다."));
        return category;
    }

    /**
     * memberNo 로 조회
     * @param memberNo
     * @return
     */
    public Member selectMember(Long memberNo) {
        Member member = memberRepository.findById(memberNo)
                .orElseThrow(() -> new RuntimeException("해당 멤버를 찾을 수 없습니다."));
        return member;
    }

    /**
     * email로 조회
     * @param email
     * @return
     */
    public Member selectMember(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("해당 멤버를 찾을 수 없습니다."));
        return member;
    }
}
