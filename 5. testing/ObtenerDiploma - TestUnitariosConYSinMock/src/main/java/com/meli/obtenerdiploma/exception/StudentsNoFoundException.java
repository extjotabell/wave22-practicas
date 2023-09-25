package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class StudentsNoFoundException extends ObtenerDiplomaException {
    public StudentsNoFoundException() {
        super("No se encontraron alumnos en el sistema", HttpStatus.NOT_FOUND);
    }
}
