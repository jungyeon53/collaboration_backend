package com.team1060.golf.dao;

import com.team1060.golf.entity.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCategory {

    private Long parentCategory;
    private Long childCategory;
    private int depth;
    private String name;


    public static Category insertCategory(RegisterCategory category){
        return Category.builder()
                .parentCategory(category.getParentCategory())
                .depth(category.getDepth())
                .name(category.getName())
                .build();
    }
}
