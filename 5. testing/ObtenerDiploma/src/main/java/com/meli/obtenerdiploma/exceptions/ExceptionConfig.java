package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.dto.ExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ExceptionDto(
                        "Se encontraron los siguientes errores en las validaciones",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())),
                HttpStatus.BAD_REQUEST
        );

    }
}
