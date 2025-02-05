package com.maxDev.java.controllers;

import com.maxDev.java.dto.AuthDto;
import com.maxDev.java.dto.RegisterRequestDTO;
import com.maxDev.java.dto.RequestRefreshDto;
import com.maxDev.java.dto.TokenResponseDto;
import com.maxDev.java.repositories.UsuarioRepository;
import com.maxDev.java.services.AutenticacaoService;
import com.maxDev.java.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDto login(@RequestBody AuthDto body){
        System.out.println("EMAIL"+ body.email());
        var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(body.email(), body.senha());
        System.out.println("usuarioAutenticationToken"+ usuarioAutenticationToken);
        authenticationManager.authenticate(usuarioAutenticationToken);
        System.out.println("usuarioAutenticationToken"+ authenticationManager.authenticate(usuarioAutenticationToken));
        return autenticacaoService.obterToken(body);
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDto authRefreshToken(@RequestBody RequestRefreshDto requestRefreshDto) {
        return autenticacaoService.obterRefreshToken(requestRefreshDto.refreshToken());
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDTO body){
        return  usuarioService.register(body);
    }
}
