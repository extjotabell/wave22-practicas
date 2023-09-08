package com.renzobayarri.blog.exceptions;

import com.renzobayarri.blog.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleBlogNotFoundException(BlogNotFoundException blogNotFoundException){
        return new ResponseEntity<>(new ExceptionDto(blogNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> handleIdAlreadyExistsException(IdAlreadyExistsException idAlreadyExistsException){
        return new ResponseEntity<>(new ExceptionDto(idAlreadyExistsException.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
