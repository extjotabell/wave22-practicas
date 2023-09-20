package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        List<ObjectError> errors = e.getAllErrors();
        List<String> erroresList = new ArrayList<>();
        for (ObjectError er: errors ) {
            erroresList.add(er.getDefaultMessage());
        }
        return new ResponseEntity<>(erroresList, HttpStatus.BAD_REQUEST);
    }
}
