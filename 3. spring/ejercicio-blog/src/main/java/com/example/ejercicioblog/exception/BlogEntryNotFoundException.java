package com.example.ejercicioblog.exception;

public class BlogEntryNotFoundException extends RuntimeException {

    public BlogEntryNotFoundException(String message) {
        super(message);
    }

}
