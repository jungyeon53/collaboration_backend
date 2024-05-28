package com.team1060.golf.dao;

import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.BoardAttach;
import com.team1060.golf.entity.Category;
import com.team1060.golf.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Map;

@Getter
@Setter
public class RegisterQnA {

    // 게시글
    private Long categoryNo;
    private Long memberNo;
    private String title;
    private String content;

    // 첨부파일
    private Long boardNo;
    private String path;
    private String name;

    public Board registerQnA(Category category, Member member){
        return Board.builder()
                .category(category)
                .member(member)
                .title(this.title)
                .content(this.content)
                .regdate(ZonedDateTime.now())
                .build();
    }

    public BoardAttach registerQnaAttach(Board board, String path, String name){
        return BoardAttach.builder()
                .board(board)
                .path(path)
                .name(name)
                .build();
    }
}
