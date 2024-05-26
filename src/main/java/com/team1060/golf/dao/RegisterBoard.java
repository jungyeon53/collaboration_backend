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

    private Long categoryNo;
    private Long memberNo;
    private String title;
    private String content;


    public Board registerBoard(Category category, Member member){
        return Board.builder()
                .category(category)
                .member(member)
                .title(this.title)
                .content(this.content)
                .regdate(ZonedDateTime.now())
                .build();
    }
}
