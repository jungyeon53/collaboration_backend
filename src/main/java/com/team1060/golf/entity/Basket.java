package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_p_basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketNo;

    @ManyToOne
    @JoinColumn(name = "productNo")
    private Product product;
    private int count;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;

    private boolean payYn;
}
