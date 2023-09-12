package com.renzobayarri.linktracker.exceptions;

import com.renzobayarri.linktracker.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleLinkNotFoundException(LinkNotFoundException linkNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto(linkNotFoundException.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ExceptionDto> handleIOException(IOException ioException) {
        ExceptionDto exceptionDto = new ExceptionDto("No se pudo hacer la redirección");
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ExceptionDto> handleIncorrectPasswordException(IncorrectPasswordException incorrectPasswordException) {
        ExceptionDto exceptionDto = new ExceptionDto(incorrectPasswordException.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionDto> handleMissingServletRequestParameterException(MissingServletRequestParameterException missingServletRequestParameterException) {
        ExceptionDto exceptionDto = new ExceptionDto(missingServletRequestParameterException.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
