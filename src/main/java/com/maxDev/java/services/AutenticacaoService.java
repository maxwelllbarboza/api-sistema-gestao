package com.maxDev.java.services;

import com.maxDev.java.dto.AuthDto;
import com.maxDev.java.dto.TokenResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoService extends UserDetailsService {

    public TokenResponseDto obterToken(AuthDto authDto);

    public String validaTokenJwt(String token);

    TokenResponseDto obterRefreshToken(String s);
}
