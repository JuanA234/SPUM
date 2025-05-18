package com.example.spum_backend.enumeration;

import lombok.Getter;

@Getter
public enum BookingStatusEnum {

    BOOKED("BOOKED"),
    IN_PROCESS("IN_PROCESS"),
    RETURNED("RETURNED");

    private final String bookingStatus;

    BookingStatusEnum(String status) {
        this.bookingStatus = status;
    }
}
