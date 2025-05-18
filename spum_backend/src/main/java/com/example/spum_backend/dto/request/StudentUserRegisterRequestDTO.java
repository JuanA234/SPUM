package com.example.spum_backend.dto.request;

public record StudentUserRegisterRequestDTO(String firstName, String lastName, String email, String password, Long studentCollegeId) {
}
