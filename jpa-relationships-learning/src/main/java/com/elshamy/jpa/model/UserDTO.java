package com.elshamy.jpa.model;

public record UserDTO(
        Long id,
        String name,
        Long profile_id
) {}
