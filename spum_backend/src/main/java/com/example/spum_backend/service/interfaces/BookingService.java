package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.request.BookingRequestDTO;
import com.example.spum_backend.dto.response.BookingResponseDTO;
import com.example.spum_backend.enumeration.BookingStatusEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO booking);
    void updateBookingStatus(Long id, BookingStatusEnum status);
}
