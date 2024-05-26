package com.team1060.golf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_p_image")
public class ProductImage {

    @Id
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "prodcutNo")
    private Product product;
    private String path;
    private String type;
}
