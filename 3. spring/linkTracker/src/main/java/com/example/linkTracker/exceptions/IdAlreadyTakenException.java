package com.example.linkTracker.exceptions;

public class IdAlreadyTakenException extends RuntimeException {
    public IdAlreadyTakenException(){

    }
    public IdAlreadyTakenException(Integer id) {
        super(String.format("El id del link: %s ya existe", id));
    }
}
