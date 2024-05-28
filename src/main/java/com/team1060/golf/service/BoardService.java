package com.team1060.golf.service;

import com.team1060.golf.dao.RegisterBoard;
import com.team1060.golf.dao.RegisterQnA;
import com.team1060.golf.entity.Board;
import com.team1060.golf.entity.BoardAttach;
import com.team1060.golf.entity.Category;
import com.team1060.golf.entity.Member;
import com.team1060.golf.repository.BoardAttachRepository;
import com.team1060.golf.repository.BoardRepository;
import com.team1060.golf.utils.EntityFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {

    private static final String BOARDATTACH_PATH = "src/main/resources/static/img/board/";

    private final BoardRepository boardRepository;
    private final BoardAttachRepository boardAttachRepository;
    private final EntityFetcher entityFetcher;

    /**
     * 공지사항 & 자주찾는 질문 등록
     * @param board
     */
    public void registerNotice(RegisterBoard board){
       Category category = entityFetcher.getCategory(board.getCategoryNo());
       Member member = entityFetcher.getMember(board.getMemberNo());
       Board registerBoard = boardRepository.save(board.registerBoard(category, member));
       boardRepository.save(registerBoard);
    }

    /**
     * 1대1 문의 등록
     * @param qna
     * @param files
     * @throws IOException
     */
    public void rsgisterQnA(RegisterQnA qna, MultipartFile[] files) throws IOException {
        Category category =
                entityFetcher.getCategory(qna.getCategoryNo());
        Member member = entityFetcher.getMember(qna.getMemberNo());
        // 게시글
        Board registerBoard = boardRepository.save(qna.registerQnA(category, member));
        List<BoardAttach> list = new ArrayList<>();
        for(MultipartFile file : files){
        String name = file.getOriginalFilename();
        String path = saveFile(file, registerBoard.getBoardNo());
        list.add(qna.registerQnaAttach(registerBoard, path, name));
        }
        boardAttachRepository.saveAll(list);
    }

    /**
     * 파일 저장
     * @param file
     * @param boardNo
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile file, Long boardNo) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = BOARDATTACH_PATH + boardNo;
        Path directory = Paths.get(path);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        Path filePath = Paths.get(path, fileName);
        Files.write(filePath, file.getBytes());
        return filePath.toString();
    }
}
