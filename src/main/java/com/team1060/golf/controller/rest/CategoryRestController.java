package com.team1060.golf.controller.rest;

import com.team1060.golf.dao.RegisterCategory;
import com.team1060.golf.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category/")
public class CategoryRestController {

    private final CategoryService categoryService;

    /**
     * 카테고리 등록
     * @param category
     * @return
     */
    @PostMapping("insert")
    public ResponseEntity<String> registerCategory(@RequestBody RegisterCategory category){
        categoryService.registerCatogory(category);
        return ResponseEntity.ok("카테고리 등록 완료");
    }

}
