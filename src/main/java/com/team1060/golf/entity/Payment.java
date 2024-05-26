package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_p_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentNo;
    private ZonedDateTime paymentDate;
    private String paymentMethod;
    private int amount;
    private int installment;
    private String card;

}
