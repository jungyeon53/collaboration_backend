package com.team1060.golf.dto;


import com.team1060.golf.entity.Member;
import com.team1060.golf.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class BoardDto {
    private Long boardNo;
    private Category category;

//    private Member member; 현재는 멤버 정보 필요 없음
    private String title;
    private String content;
    private ZonedDateTime regdate;
}
