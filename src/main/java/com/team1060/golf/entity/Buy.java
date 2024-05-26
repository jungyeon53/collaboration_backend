package com.team1060.golf.entity;

import com.team1060.golf.enums.PayStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_p_buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyNo;

    @ManyToOne
    @JoinColumn(name = "productNo")
    private Product product; // 상품

    @ManyToOne
    @JoinColumn(name = "userNo")
    private Member member; // 회원번호

    @ManyToOne
    @JoinColumn(name = "shippingNo")
    private Shipping shipping; // 배송지

    @OneToOne
    @JoinColumn(name = "paymentNo")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    private String deliveryMessage;

}
