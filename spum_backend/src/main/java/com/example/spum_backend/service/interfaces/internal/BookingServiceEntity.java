package com.example.spum_backend.service.interfaces.internal;

import com.example.spum_backend.entity.Booking;

import java.util.List;

public interface BookingServiceEntity {
    List<Booking> getAllBookingsSoonToEnd();
    void getBookingsWithNoProcessing();
    Booking getBookingById(Long id);
}
