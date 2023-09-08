package com.example.blog.exception;

public class DuplicatedIdException extends RuntimeException {
    public DuplicatedIdException(String message) {
        super(message);
    }
}
