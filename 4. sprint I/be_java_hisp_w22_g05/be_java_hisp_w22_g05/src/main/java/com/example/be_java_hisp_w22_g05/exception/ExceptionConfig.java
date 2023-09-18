package com.example.be_java_hisp_w22_g05.exception;

import com.example.be_java_hisp_w22_g05.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    
    //Ultima Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> unexpectedException(Exception e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>(new ExceptionDto("Unexpected Error"), HttpStatus.BAD_REQUEST);
    }
}
