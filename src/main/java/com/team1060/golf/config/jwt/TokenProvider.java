package com.team1060.golf.config.jwt;

import com.team1060.golf.dao.LoginMember;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    private String makeToken(Date expiration, LoginMember member){
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiration) // 만료시간
                .setSubject(member.getEmail())
                .claim("email", member.getEmail())
                .claim("nickname", member.get)
    }
}
