package com.example.spum_backend.exception;

public class UserHasInProcessPenalty extends RuntimeException {
    public UserHasInProcessPenalty(String message) {
        super(message);
    }
}
