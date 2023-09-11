package com.example.concesionaria.exception;

public class NonSenseException extends RuntimeException{
    public NonSenseException(){};

    public NonSenseException(String message){super(message);};
}
