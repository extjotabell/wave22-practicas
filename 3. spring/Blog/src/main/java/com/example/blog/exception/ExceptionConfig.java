package com.example.blog.exception;

import com.example.blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(DuplicatedIdException.class)
    public ResponseEntity<?> duplicatedId(DuplicatedIdException e){
        return new ResponseEntity<>(
                new ErrorDTO(e.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(BlogNotFound.class)
    public ResponseEntity<?> notFound(BlogNotFound e){
        return new ResponseEntity<>(
                new ErrorDTO(e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(NoBlogsCreated.class)
    public ResponseEntity<?> notFound(NoBlogsCreated e){
        return new ResponseEntity<>(
                new ErrorDTO(e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
