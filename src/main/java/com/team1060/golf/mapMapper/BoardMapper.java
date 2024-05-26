package com.team1060.golf.mapMapper;

import com.team1060.golf.dto.BoardDto;
import com.team1060.golf.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto boardToBoardDTO(Board board);
}
