package com.team1060.golf.service;

import com.team1060.golf.dao.RegisterBoard;
import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Category;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.BoardRepository;
import com.team1060.golf.repository.CategoryRepository;
import com.team1060.golf.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 공지사항 & 자주찾는 질문 등록
     * @param board
     */
    public void registerNotice(RegisterBoard board){
       Category category =
               categoryRepository.findById(board.getCategoryNo()).orElseThrow(() -> new RuntimeException("해당 카테고리를 찾을 수 없습니다."));
        Member member =
                memberRepository.findById(board.getMemberNo()).orElseThrow(() -> new RuntimeException("해당 멤버를 찾을 수 없습니다."));
        Board registerBoard = boardRepository.save(board.registerBoard(category, member));
        boardRepository.save(registerBoard);
    }
}
