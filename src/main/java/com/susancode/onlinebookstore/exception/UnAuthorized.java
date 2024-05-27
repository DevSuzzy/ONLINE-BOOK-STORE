package com.susancode.onlinebookstore.exception;
/**
 * Custom exception class for representing unauthorized access errors.
 * it extends RuntimeException to indicate runtime exceptions.
 */


public class UnAuthorized extends RuntimeException{
    public UnAuthorized(String message) {
        super(message);
    }
}
