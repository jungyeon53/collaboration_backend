package com.team1060.golf.mapMapper;

import com.team1060.golf.dto.MemberDto;
import com.team1060.golf.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberDto memberToMemberDTO(Member member);
}
