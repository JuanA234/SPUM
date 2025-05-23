package com.example.spum_backend.enumeration;

import lombok.Getter;

@Getter
public enum BookingStatusEnum {

    BOOKED("BOOKED"),
    IN_PROCESS("IN_PROCESS"),
    RETURNED("RETURNED"),
    IN_PROCESS_OF_RETURN("IN_PROCESS_OF_RETURN"),
    CANCELLED("CANCELLED");

    private final String bookingStatus;

    BookingStatusEnum(String status) {
        this.bookingStatus = status;
    }
}
