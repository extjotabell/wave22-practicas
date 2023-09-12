package com.example.linkTracker.exceptions;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {
        super(String.format("El password ingresado es incorrecto"));
    }
}
