package com.example.spum_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {
    LocalDateTime startTime;
    Long itemId;
    String email;
}
