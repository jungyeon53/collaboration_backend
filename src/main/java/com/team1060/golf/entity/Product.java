package com.team1060.golf.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;
    @ManyToOne
    @JoinColumn(name = "brandNo")
    private Brand brand;
    private String productName;
    private Integer price;
    private Float discount;
    private LocalDateTime regdate;
    private String benefit;
    private String noInterestInstallment;
    private boolean isShopPickup;
    private boolean isShopDelivery;
}
