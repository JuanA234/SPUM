package com.example.spum_backend.dto.request;

import com.example.spum_backend.enumeration.RolesEnum;

public record UserRegisterRequestDTO(String name, String lastName, String email, String password, RolesEnum role) {
}
