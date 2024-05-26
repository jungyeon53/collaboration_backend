package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandNo;
    private String brandName;
}
