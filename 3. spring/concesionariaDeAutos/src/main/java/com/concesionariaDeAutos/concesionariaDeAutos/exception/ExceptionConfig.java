package com.concesionariaDeAutos.concesionariaDeAutos.exception;

import com.concesionariaDeAutos.concesionariaDeAutos.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<?> idAlreadyExistsException(IdAlreadyExistsException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.CONFLICT);
    }
}
