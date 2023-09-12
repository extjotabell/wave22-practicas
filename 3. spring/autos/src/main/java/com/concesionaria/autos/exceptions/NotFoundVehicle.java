package com.concesionaria.autos.exceptions;

public class NotFoundVehicle extends RuntimeException {
    public NotFoundVehicle(){}
    public NotFoundVehicle(String message)
    {
        super(message);
    }
}
