package com.example.link_tracker.exception;

public class NotFoundUrlException extends RuntimeException {
    public NotFoundUrlException(){}
    public NotFoundUrlException(String message)
    {
        super(message);
    }
}
