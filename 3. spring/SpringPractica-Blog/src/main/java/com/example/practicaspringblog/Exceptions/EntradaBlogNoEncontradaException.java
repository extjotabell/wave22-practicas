package com.example.practicaspringblog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se encontro una entrada de blog con ese ID")
public class EntradaBlogNoEncontradaException extends RuntimeException {
    public EntradaBlogNoEncontradaException (String mensaje){
        super(mensaje);
    }
}
