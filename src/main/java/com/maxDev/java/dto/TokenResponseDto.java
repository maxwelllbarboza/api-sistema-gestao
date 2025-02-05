package com.maxDev.java.dto;


import lombok.Builder;

@Builder
public record TokenResponseDto(String token, String refreshToken) {
}
