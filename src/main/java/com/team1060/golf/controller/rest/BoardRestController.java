package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.RegisterBoard;
import com.team1060.golf.dao.RegisterQnA;
import com.team1060.golf.dao.SearchBoard;
import com.team1060.golf.dto.BoardDto;
import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardRestController {

    private final BoardService boardService;

    /**
     * 공지사항 & 자주찾는 질문 등록
     * @param board
     * @return
     */
    @PostMapping("Noticeinsert")
    public ResponseEntity<String> registerNotice(@RequestBody RegisterBoard board){
        boardService.registerNotice(board);
        return ResponseEntity.ok("공지사항 등록 완료");
    }

    /**
     * 1대1 문의 등록
     * @param qnA
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("QnaInsert")
    public ResponseEntity<String> registerQnA(@RequestPart(value = "qna") RegisterQnA qnA, @RequestPart(value = "files", required = false) MultipartFile[] files) throws IOException {
        boardService.rsgisterQnA(qnA, files);
        return ResponseEntity.ok("1:1 문의 등록 완료");
    }

    /**
     * 공지사항, 자주찾는 질문 게시글 검색
     * @param searchBoard
     * @return
     */
    @PostMapping("search")
    public List<BoardDto> searchBoard(@RequestBody SearchBoard searchBoard){
        return boardService.searchBoardList(searchBoard.getCategoryNo(), searchBoard.getTitle());
    }

    /**
     * 게시판 메인화면 검색창 (공지사항, 자주찾는 질문 검색)
     * @param keyword
     * @return
     */
    @PostMapping("mainSearch")
    public List<BoardDto> searchMainsearch(@RequestParam String keyword){
        return boardService.searchMainBoardList(keyword);
    }
}
