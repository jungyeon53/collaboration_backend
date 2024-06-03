package com.team1060.golf.controller.view;

import com.team1060.golf.dto.CategoryDto;
import com.team1060.golf.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category/")
public class CategoryViewController {

    private final CategoryService categoryService;

    /**
     * 카테고리 전체 조회
     * @return
     */
    @GetMapping("list")
    public List<CategoryDto> viewAllCategory(){
        return categoryService.viewAllCategory();
    }

    /**
     * 카테고리 1개 조회
     * @param categoryNo
     * @return
     */
    @GetMapping("{categoryNo}")
    public CategoryDto viewCategory(@PathVariable(name = "categoryNo") Long categoryNo){
        return categoryService.viewCategory(categoryNo);
    }

    /**
     * 2뎁스 카테고리 선택시 하위 카테고리 조회
     * @param categoryNo
     * @return
     */
    @GetMapping("parentNo/{categoryNo}")
    public List<CategoryDto> viewParentCategory(@PathVariable(name = "categoryNo") Long categoryNo){
        return categoryService.viewParentCategory(categoryNo, 3);
    }
}
