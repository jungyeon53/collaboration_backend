package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_p_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeNo;
    private String typeName;
    private int parentTypeNo;
    private int childTypeNo;
}
