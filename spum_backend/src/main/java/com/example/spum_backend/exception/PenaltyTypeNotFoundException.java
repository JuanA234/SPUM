package com.example.spum_backend.exception;

public class PenaltyTypeNotFoundException extends ResourceNotFoundException {
    public PenaltyTypeNotFoundException(String message) {
        super(message);
    }
}
