package com.example.blogProyect.exceptions;

public class BlogExistsException extends RuntimeException {
    public BlogExistsException(int id) {
        super("El Blog con el id: " + id + " no se encuentra disponible");
    }
}
