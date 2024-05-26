package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_g_image")
public class GolfImage {

    @Id
    private UUID uuid;
    private String category; // 이미지 카테고리

    @ManyToOne
    @JoinColumn(name = "courseNo")
    private Course golfCourse; // 코스 번호
    private String path; // 이미지 경로
}
