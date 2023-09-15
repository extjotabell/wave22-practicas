package com.calculadoraDeCalorias.calculadoraDeCalorias.exception;

import com.calculadoraDeCalorias.calculadoraDeCalorias.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e)
    {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
