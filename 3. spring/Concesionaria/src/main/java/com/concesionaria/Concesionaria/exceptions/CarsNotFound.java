package com.concesionaria.Concesionaria.exceptions;

public class CarsNotFound extends RuntimeException{

    public CarsNotFound(String message) {
        super(message);
    }
}
