package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_p_cancel")
public class Cancel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CancelNo;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;

    private LocalDate cancelDate;
    private LocalTime cancelTime;
}
