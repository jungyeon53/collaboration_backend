package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_p_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "productNo")
    private Product product;

    private float rate;
    private String title;
    private String content;
    private ZonedDateTime regdate;
}
