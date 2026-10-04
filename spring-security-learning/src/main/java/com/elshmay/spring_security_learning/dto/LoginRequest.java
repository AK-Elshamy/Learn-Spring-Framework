package com.elshmay.spring_security_learning.dto;

public record LoginRequest(
        String username,
        String password
) {}