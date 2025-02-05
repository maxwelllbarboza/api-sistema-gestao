package com.maxDev.java.dto.login;

import com.maxDev.java.entities.UserRole;

public record RegisterRequestDTO(String name, String email, String password, UserRole role) {}
