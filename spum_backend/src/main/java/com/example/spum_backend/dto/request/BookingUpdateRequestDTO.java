package com.example.spum_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import com.example.spum_backend.enumeration.BookingStatusEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingUpdateRequestDTO {
    private Long bookingId;                // Obligatorio para identificar la reserva
    private LocalDateTime startTime;      // Opcional, si quieres permitir actualizar
    private Long itemId;                  // Opcional, si quieres permitir cambiar el ítem
    private String email;                 // Opcional, para actualizar el estudiante
    private BookingStatusEnum status;    // Opcional, actualizar el estado de la reserva
}
