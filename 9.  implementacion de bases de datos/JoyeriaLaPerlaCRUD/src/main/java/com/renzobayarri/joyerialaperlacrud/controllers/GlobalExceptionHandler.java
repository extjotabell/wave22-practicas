package com.renzobayarri.joyerialaperlacrud.controllers;

import com.renzobayarri.joyerialaperlacrud.dto.ErrorDTO;
import com.renzobayarri.joyerialaperlacrud.dto.ErrorsDTO;
import com.renzobayarri.joyerialaperlacrud.exceptions.JoyaNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ErrorsDTO(ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList()));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ErrorDTO("Se ingresaron valores no esperados"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ErrorDTO("Existen errores en el payload"));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorsDTO> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(new ErrorsDTO(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList()));
    }

    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleJoyaNotFoundException(JoyaNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
    }
}
