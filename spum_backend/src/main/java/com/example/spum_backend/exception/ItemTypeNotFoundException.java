package com.example.spum_backend.exception;

public class ItemTypeNotFoundException extends RuntimeException {
    public ItemTypeNotFoundException(String message) {
        super(message);
    }
}
