package com.example.blogProyect.exceptions;

import com.example.blogProyect.dtos.ExceptionDto;
import org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

    @ExceptionHandler(BlogExistsException.class)
    public ResponseEntity<ExceptionDto> handleBlogExistsException(BlogExistsException blogExists)
    {
        ExceptionDto exceptionDto = new ExceptionDto(blogExists.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }


}
