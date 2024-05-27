package com.susancode.onlinebookstore.exception;
/**
 * Custom exception class for representing not found errors.
 * it extends RuntimeException to indicate runtime exceptions.
 */

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
