package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.RegisterBoard;
import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
