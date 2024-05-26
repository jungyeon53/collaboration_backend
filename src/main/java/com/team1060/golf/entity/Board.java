package com.team1060.golf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_board")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    @ManyToOne
    @JoinColumn(name = "categoryNo")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;
    private String content;
    private String title;

    private ZonedDateTime regdate;
}
