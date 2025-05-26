package com.example.spum_backend.exception;

public class BookingNotFoundException extends ResourceNotFoundException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
