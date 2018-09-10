package com.esc.bookstest.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String format) {
        super(format);
    }
}
