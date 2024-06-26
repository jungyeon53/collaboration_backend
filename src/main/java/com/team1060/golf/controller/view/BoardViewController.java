package com.team1060.golf.controller.view;

import com.team1060.golf.dto.BoardDto;
import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Category;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.BoardRepository;
import com.team1060.golf.repository.MemberRepository;
import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardViewController {

    private final BoardService boardService;


    /**
     * 모든 게시글 조회
     * @return
     */
    @GetMapping("list")
    public List<BoardDto> viewAllBoard(){
        return boardService.viewAllBoard();
    }

    /**
     * 카테고리별 게시글 조회
     * @param categoryNo
     * @return
     */
    @GetMapping("category/{categoryNo}")
    public List<BoardDto> viewCategoryBoard(@PathVariable(name = "categoryNo") Long categoryNo){
        return boardService.viewCategoryBoard(categoryNo);
    }

    /**
     * 멤버별 1대1 문의 리스트
     * @param memberNo
     * @return
     */
    @GetMapping("QnA/{memberNo}")
    public List<BoardDto> viewQnABoard(@PathVariable(name = "memberNo") Long memberNo){
        return boardService.viewQnABoard(memberNo);
    }

    /**
     * 게시글 상세보기
     * @param boardNo
     * @return
     */
    @GetMapping("list/{boardNo}")
    public BoardDto viewBoard(@PathVariable(name = "boardNo") Long boardNo){
        return boardService.viewBoard(boardNo);
    }
}
