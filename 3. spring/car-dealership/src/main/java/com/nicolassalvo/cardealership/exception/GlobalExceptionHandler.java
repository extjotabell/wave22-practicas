package com.nicolassalvo.cardealership.exception;

import com.nicolassalvo.cardealership.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleCarNotFoundException(CarNotFoundException carNotFoundException){
        return new ResponseEntity<>(new ExceptionDTO(carNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
