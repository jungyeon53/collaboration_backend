package com.team1060.golf.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    private Long categoryNo;
    private Long parentCategory;
    private int depth;
    private String name;
}
