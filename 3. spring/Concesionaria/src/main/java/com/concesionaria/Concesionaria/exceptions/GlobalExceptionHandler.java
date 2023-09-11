package com.concesionaria.Concesionaria.exceptions;

import com.concesionaria.Concesionaria.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarsNotFound.class)
    public ResponseEntity<?> handleCarNotFound(CarsNotFound carNotFound){
        return new ResponseEntity<>(new ExceptionDTO(carNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
}
