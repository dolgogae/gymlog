package com.gymory.domain.user.base.dto;

import lombok.Getter;

@Getter
public enum UserRole {
    GENERAL("GENERAL"),
    TRAINER("TRAINER"),
    GYM("GYM");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
