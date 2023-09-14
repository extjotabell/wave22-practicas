package com.example.blogProyect.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super("No se encontraron entradas de blogs");
    }
}
