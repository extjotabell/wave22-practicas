package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ErrorDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDto> handlerValidations(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                new ErrorDto("Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()))
        );
    }
}
