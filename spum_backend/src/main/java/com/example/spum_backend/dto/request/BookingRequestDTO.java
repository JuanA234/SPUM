package com.example.spum_backend.dto.request;

import java.time.LocalDateTime;

public record BookingRequestDTO(LocalDateTime startTime, Long itemId, String email) {
}
