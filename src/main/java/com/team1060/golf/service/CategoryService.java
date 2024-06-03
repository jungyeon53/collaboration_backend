package com.team1060.golf.service;

import com.team1060.golf.dao.RegisterCategory;
import com.team1060.golf.dto.CategoryDto;
import com.team1060.golf.entity.Category;
import com.team1060.golf.mapMapper.CategoryMappper;
import com.team1060.golf.repository.CategoryRepository;
import com.team1060.golf.utils.EntityFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMappper categoryMappper;
    private final EntityFetcher entityFetcher;

    /**
     * 카테고리 추가
     * @param category
     */
    public void registerCatogory(RegisterCategory category){
        categoryRepository.save(RegisterCategory.insertCategory(category));
    }

    /**
     * 모든 카테고리 조회
     * @return
     */
    public List<CategoryDto> viewAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMappper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    /**
     * 카테고리 1개 조회
     * @param categoryNo
     * @return
     */
    public CategoryDto viewCategory(Long categoryNo){
        Category category = entityFetcher.selectCategory(categoryNo);
        return categoryMappper.categoryToCategoryDTO(category);
    }

    /**
     * 2뎁스 카테고리 선택시 하위 카테고리 조회
     * @param categoryNo
     * @param depth
     * @return
     */
    public List<CategoryDto> viewParentCategory(Long categoryNo , int depth){
        List<Category> categories = categoryRepository.findByParentCategoryAndDepth(categoryNo, depth);
        return categories.stream()
                .map(categoryMappper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }
}
