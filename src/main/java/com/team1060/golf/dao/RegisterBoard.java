package com.team1060.golf.dao;


import com.team1060.golf.entity.Member;
import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Category;
import com.team1060.golf.enums.Keyword;
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
    private String keyword;

    public Board registerBoard(Category category, Member member, Keyword keyword){
        return Board.builder()
                .category(category)
                .member(member)
                .title(this.title)
                .content(this.content)
                .keyword(keyword)
                .regdate(ZonedDateTime.now())
                .build();
    }
}
