package com.linkTracker.linkTracker.exception;

import com.linkTracker.linkTracker.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundexception(NotFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
