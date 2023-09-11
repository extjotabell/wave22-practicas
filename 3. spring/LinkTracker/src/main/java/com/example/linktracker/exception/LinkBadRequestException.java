package com.example.linktracker.exception;

public class LinkBadRequestException extends RuntimeException{
    public LinkBadRequestException() {

    }
    public LinkBadRequestException(String message) {super(message);}
}
