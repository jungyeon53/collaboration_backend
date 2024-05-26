package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_p_option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long option_no;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private Product Product;
    private String optionName;
    private int count;
}
