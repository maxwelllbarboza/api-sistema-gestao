package com.maxDev.java.controllers.login;

import com.maxDev.java.dto.login.LoginRequestDTO;
import com.maxDev.java.dto.login.RegisterRequestDTO;
import com.maxDev.java.services.user.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private AuthorizationService authorizationService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDTO body){
        return authorizationService.login(body);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        return authorizationService.register(body);
    }
}
