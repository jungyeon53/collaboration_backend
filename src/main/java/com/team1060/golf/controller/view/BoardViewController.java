package com.team1060.golf.controller.view;

import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.BoardRepository;
import com.team1060.golf.repository.MemberRepository;
import com.team1060.golf.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardViewController {

    private final BoardService boardService;

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;




}
