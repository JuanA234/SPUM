package com.example.spum_backend.enumeration;

import lombok.Getter;

@Getter
public enum RolesEnum {

    ADMIN("ADMIN"),
    ASSISTANT("ASSISTANT"),
    STUDENT("STUDENT");

    private final String role;

    RolesEnum(String role) {
        this.role = role;
    }

}
