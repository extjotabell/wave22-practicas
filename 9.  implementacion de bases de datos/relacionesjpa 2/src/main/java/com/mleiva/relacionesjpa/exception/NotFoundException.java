package com.mleiva.relacionesjpa.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("El modelo ingresado no se encuentra en la base de datos");
    }

}
