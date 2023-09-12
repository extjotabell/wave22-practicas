package com.renzobayarri.concesionaria.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("No se han encontrado autos");
    }

}
