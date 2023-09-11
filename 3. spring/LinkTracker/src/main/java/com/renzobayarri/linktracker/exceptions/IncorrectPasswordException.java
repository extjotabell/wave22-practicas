package com.renzobayarri.linktracker.exceptions;

public class IncorrectPasswordException extends RuntimeException{

    public IncorrectPasswordException() {
        super("The password doesn't match");
    }
}
