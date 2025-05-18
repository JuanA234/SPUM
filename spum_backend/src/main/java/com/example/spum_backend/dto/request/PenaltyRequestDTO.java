package com.example.spum_backend.dto.request;

import java.time.LocalDateTime;

public record PenaltyRequestDTO(String description, LocalDateTime penaltyDate, Long penaltyType, String email) {
}
