package com.maxDev.java.dto;

import com.maxDev.java.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private RoleEnum role;
}






