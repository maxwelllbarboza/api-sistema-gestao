package com.maxDev.java.dto;

import com.maxDev.java.enums.RoleEnum;

public record UsuarioDto(
        String name,
        String email,
        String password,
        RoleEnum role
) {
}
