package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> exceptionValidator(MethodArgumentNotValidException e){
        return new ResponseEntity<ExceptionDto>(
                new ExceptionDto("MethodArgumentNotValidException: Errores en las siguientes validaciones: ",
                e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> exceptionValidation(ConstraintViolationException e){
        return new ResponseEntity<>(new ExceptionDto("Errores en las siguientes validaciones:",
                e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())),
                HttpStatus.CONFLICT);
    }

}
