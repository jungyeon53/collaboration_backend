package com.team1060.golf.entity;

import com.team1060.golf.enums.GolfStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_g_reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveNo; // 예약 번호

    // 회원번호
    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "courseNo")
    private Course course; // 코스번호
    @ManyToOne
    @JoinColumn(name = "golfNo")
    private Golf golf; // 골프장 번호

    private String email; // 이메일
    private ZonedDateTime reserveTime; // 예약 완료 날짜 시간
    private LocalTime time; // 예약시간
    private LocalDate date; // 예약날짜

    @Enumerated
    private GolfStatus golfStatus; // 예약 상태
}
