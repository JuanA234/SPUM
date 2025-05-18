package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.request.BookingRequestDTO;
import com.example.spum_backend.dto.response.BookingResponseDTO;

import java.time.LocalDateTime;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO booking);

}
