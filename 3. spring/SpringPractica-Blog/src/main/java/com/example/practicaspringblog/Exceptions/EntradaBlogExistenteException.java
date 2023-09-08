package com.example.practicaspringblog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ya existe una entrada de blog con ese ID")
public class EntradaBlogExistenteException extends RuntimeException {
    public EntradaBlogExistenteException (String mensaje){
        super(mensaje);
    }
}
