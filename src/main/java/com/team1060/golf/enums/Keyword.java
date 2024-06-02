package com.team1060.golf.enums;


import lombok.Getter;

@Getter
public enum Keyword {
    DELIVERY("배송문의"),
    RESERVATION("예약문의"),
    PRIVACY("개인정보문의"),
    PAY("결제문의");

    private final String option;

    Keyword(String option) {
        this.option = option;
    }

}

