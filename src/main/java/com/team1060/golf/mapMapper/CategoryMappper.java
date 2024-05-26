package com.team1060.golf.mapMapper;

import com.team1060.golf.dto.CategoryDto;
import com.team1060.golf.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMappper {

    CategoryDto categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDto categoryDTO);
}
