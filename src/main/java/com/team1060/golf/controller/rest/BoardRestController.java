package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.RegisterBoard;
import com.team1060.golf.dao.RegisterQnA;
import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public ResponseEntity<String> registerQnA(RegisterQnA qnA, @RequestPart("files") MultipartFile[] files) throws IOException {
        boardService.rsgisterQnA(qnA, files);
        return ResponseEntity.ok("1:1 문의 등록 완료");
    }

}
