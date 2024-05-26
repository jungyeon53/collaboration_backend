package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_golf")
public class Golf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long golfNo; // 골프장 pk
    private String region; // 지역
    private String name; // 골프장명
    private String description; // 골프장 설명
    private int holes; // 홀 수
    private int pars; // 파 수
    private int landArea; // 전장
    private String address; // 주소
    private String contact; // 전화번호
    private String fax; // 팩스번호
}
