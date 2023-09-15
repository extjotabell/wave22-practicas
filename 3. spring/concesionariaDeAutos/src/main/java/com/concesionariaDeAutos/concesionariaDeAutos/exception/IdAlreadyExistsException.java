package com.concesionariaDeAutos.concesionariaDeAutos.exception;

public class IdAlreadyExistsException extends RuntimeException{
    public IdAlreadyExistsException(String message) {
        super(message);
    }
}
