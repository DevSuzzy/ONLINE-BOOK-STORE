package com.susancode.onlinebookstore.exception;

public class UnAuthorized extends RuntimeException{
    public UnAuthorized(String message) {
        super(message);
    }
}
