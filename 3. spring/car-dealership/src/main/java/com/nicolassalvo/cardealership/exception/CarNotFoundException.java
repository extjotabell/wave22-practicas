package com.nicolassalvo.cardealership.exception;

public class CarNotFoundException extends  RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
    public CarNotFoundException(int id) {
        super("No se encontró el auto con id: " + id);
    }
}
