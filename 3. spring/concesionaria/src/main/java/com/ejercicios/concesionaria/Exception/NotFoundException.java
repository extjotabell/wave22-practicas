package com.ejercicios.concesionaria.Exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("El modelo ingresado no se encuentra en la base de datos");
    }

}