package com.w22_g03.be_java_hisp_w22_g03_bayarri.exception;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException notFoundException) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(notFoundException.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> handleBadRequestException(BadRequestException badRequestException){
        ExceptionDTO exceptionDTO = new ExceptionDTO(badRequestException.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Invalid order request");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("The request contains invalid field values");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("The request contains invalid field values");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
                                                        HttpHeaders headers,
                                                        HttpStatusCode status,
                                                        WebRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("The request contains invalid field values");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatusCode status,
                                                                          WebRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("The request contains invalid field values");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

}