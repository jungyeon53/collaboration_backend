package com.team1060.golf.repository;

import com.team1060.golf.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long categoryNo);

    List<Category> findByParentCategoryAndDepth(Long categoryNo, int depth);
}

