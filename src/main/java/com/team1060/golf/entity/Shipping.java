package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingNo;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member;

    private String recipient;
    private String destination;
    private String contact;
    private boolean isDefaultShipping;
    private String roadAddrPart1;
    private String roadAddrPart2;
    private String zipNo;
    private String addrDetail;
}
