package com.example.users.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException() {
        super();
    }
}
