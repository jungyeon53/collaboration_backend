package com.team1060.golf.dao;


import com.team1060.golf.entity.Member;
import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Category;
import lombok.*;

import java.time.ZonedDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterBoard {

    private Category category;
    private Member member;
    private String title;
    private String content;
    private ZonedDateTime regdate;


    public static Board registerBoard(RegisterBoard registerBoard){
        return Board.builder()
                .category(registerBoard.getCategory())
                .member(registerBoard.getMember())
                .title(registerBoard.getTitle())
                .content(registerBoard.getContent())
                .regdate(ZonedDateTime.now())
                .build();
    }
}
