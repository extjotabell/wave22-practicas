package com.ejercicios.concesionaria.Exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("No se han encontrado autos");
    }

}