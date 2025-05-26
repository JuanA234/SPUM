package com.example.spum_backend.exception;

public class ItemNotFoundException extends ResourceNotFoundException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
