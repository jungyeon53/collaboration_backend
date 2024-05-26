package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_g_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseNo; // 코스 번호

    @ManyToOne
    @JoinColumn(name = "golfNo")
    private Golf golf; // 골프장 번호
    private String courseName; // 코스이름
    private int greenpee; // 그린피
    private LocalTime golfTime; // 코스 시간
    private LocalDate golfDate; // 코스 날짜
    private int golfStatus; // 예약상태
}
