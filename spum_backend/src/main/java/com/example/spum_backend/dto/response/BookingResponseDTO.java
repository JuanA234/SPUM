package com.example.spum_backend.dto.response;

import java.time.LocalDateTime;

public record BookingResponseDTO(String userName, String userLastName, LocalDateTime startTime, LocalDateTime endTime) {
}
