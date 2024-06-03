package com.team1060.golf.config.jwt;

import com.team1060.golf.entity.Member;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    /**
     * acessToken, refreshToken 생성
     * @param expiration
     * @param member
     * @return
     */
    private String makeJwt(Date expiration, Member member){
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiration) // 만료시간
                .setSubject(member.getEmail())
                .claim("email", member.getEmail())
                .claim("nickname", member.getNickname())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    /**
     * 토큰 만료시간
     * @param member
     * @param expriedAt
     * @return
     */
    public String makeToken(Member member, Duration expriedAt){
        Date now = new Date();
        return makeJwt(new Date(now.getTime() + expriedAt.toMillis()), member);
    }

}
