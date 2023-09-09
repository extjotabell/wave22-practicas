package com.spring.consecionariadeautos.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Car not founded");
    }
    public CarNotFoundException(Long id) {
        super(String.format("Car with id: %s not found", id));
    }
}
