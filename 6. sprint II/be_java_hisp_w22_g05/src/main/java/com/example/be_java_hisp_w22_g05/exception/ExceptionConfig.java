package com.example.be_java_hisp_w22_g05.exception;

import com.example.be_java_hisp_w22_g05.dto.ExceptionDto;
import com.example.be_java_hisp_w22_g05.dto.ExceptionListDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(NotFoundException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ExceptionDto> followException(FollowException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> alreadyExistsException(AlreadyExistsException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ExceptionListDto> handlerValidations(MethodArgumentNotValidException e){
        return new ResponseEntity<>(
                new ExceptionListDto("Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())),HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionListDto> exceptionValidation(ConstraintViolationException e){
        return new ResponseEntity<>(new ExceptionListDto("Errores en las siguientes validaciones:",
                e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())),
                HttpStatus.CONFLICT);
    }
    
    //Ultima Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> unexpectedException(Exception e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>(new ExceptionDto("Unexpected Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
