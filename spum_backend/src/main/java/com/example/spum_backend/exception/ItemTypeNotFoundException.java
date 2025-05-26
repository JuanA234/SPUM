package com.example.spum_backend.exception;

public class ItemTypeNotFoundException extends ResourceNotFoundException {
    public ItemTypeNotFoundException(String message) {
        super(message);
    }
}
