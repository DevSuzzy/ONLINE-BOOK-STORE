package com.susancode.onlinebookstore.exception;
/**
 * Custom exception class for representing bad request errors.
 * it extends RuntimeException to indicate runtime exceptions.
 */

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
