package com.team1060.golf.controller.view;

import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardViewController {

    private final BoardService boardService;

//    @GetMapping("all")
//    public List<BoardDto> allList() {
//        List<Board> allList = boardService.allList();
//        return allList.stream().map(this::convertToDto).collect(Collectors.toList());
//    }
//
//    private BoardDto convertToDto(Board board) {
//        BoardDto boardDto = new BoardDto();
//        boardDto.setBoardNo(board.getBoardNo());
//        boardDto.setTitle(board.getTitle());
//        boardDto.setContent(board.getContent());
//        return boardDto;
//    }
}
