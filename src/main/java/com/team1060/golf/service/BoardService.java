package com.team1060.golf.service;

import com.team1060.golf.repository.BoardRepository;
import com.team1060.golf.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 게시글 작성
     */

//    public void registerBoard(RegisterBoard insertDate){
//
//        Category category = categoryRepository.findById(insertDate.getCategory());
//        if (category != null) {
//            categoryRepository.save(category); // Category 먼저 저장
//        }
//        boardRepository.save(RegisterBoard.registerBoard(insertDate));
//    }
//
//    /**
//     * 게시글 전체 조회
//     */
//    public List<Board> allList(){
//        return boardRepository.findAll();
//    }
}
