package com.team1060.golf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String accessToken;
    private String refreshToken;
}
