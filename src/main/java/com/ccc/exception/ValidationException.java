package com.ccc.exception;

/**
 * Custom validation exception
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
