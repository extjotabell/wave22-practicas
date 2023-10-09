package com.example.demohibernate.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){ super(message);}
}
