package com.example.be_java_hisp_w22_g05.exception;

import com.example.be_java_hisp_w22_g05.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {


    //Ultima Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> unexpectedException(Exception e){
        System.out.println(e.getMessage());
        return new ResponseEntity(new ExceptionDto("Unexpected Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
