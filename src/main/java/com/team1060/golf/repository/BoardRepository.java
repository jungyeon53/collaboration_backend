package com.team1060.golf.repository;

import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByCategory(Category category);
}

