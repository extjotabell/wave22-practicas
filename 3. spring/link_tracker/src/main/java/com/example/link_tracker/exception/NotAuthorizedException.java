package com.example.link_tracker.exception;

public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException() {
    }
    public NotAuthorizedException(String message) {
        super(message);
    }
}
