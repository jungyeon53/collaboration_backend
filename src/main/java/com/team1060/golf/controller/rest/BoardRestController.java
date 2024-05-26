package com.team1060.golf.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardRestController {

//    private final BoardService boardService;
//
//    @PostMapping("insert")
//    public void RegisterBoard(@RequestBody RegisterBoard registerBoard){
//        System.out.println(registerBoard.getTitle());
//        System.out.println(registerBoard.getContent());
//        boardService.registerBoard(registerBoard);
//    }
}
