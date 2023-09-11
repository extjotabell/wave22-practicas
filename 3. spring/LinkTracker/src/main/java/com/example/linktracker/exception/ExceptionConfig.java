package com.example.linktracker.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> linkNotFoundException(LinkNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkBadRequestException.class)
    public ResponseEntity<?> linkBadRequestException(LinkBadRequestException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
