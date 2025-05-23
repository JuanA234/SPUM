package com.example.spum_backend.exception;

public class BookingConflict extends RuntimeException {
    public BookingConflict(String message) {
        super(message);
    }
}
