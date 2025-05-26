package com.example.spum_backend.controller;

import com.example.spum_backend.dto.request.BookingRequestDTO;
import com.example.spum_backend.dto.request.BookingUpdateStatusRequestDTO;
import com.example.spum_backend.dto.response.BookingResponseDTO;
import com.example.spum_backend.entity.Booking;
import com.example.spum_backend.service.interfaces.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/add")
    public BookingResponseDTO addBooking(@RequestBody BookingRequestDTO booking) {
        return bookingService.createBooking(booking);
    }

    @PostMapping("/update-status")
    public String updateBooking(@RequestBody BookingUpdateStatusRequestDTO booking) {
        bookingService.updateBookingStatus(booking);
        return "Booking updated to" + booking.getStatus();
    }

}
