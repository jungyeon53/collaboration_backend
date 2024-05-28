package com.team1060.golf.repository;

import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.BoardAttach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardAttachRepository extends JpaRepository<BoardAttach, Long> {

}

