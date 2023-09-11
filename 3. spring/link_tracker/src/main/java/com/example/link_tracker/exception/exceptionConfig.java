package com.example.link_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@ControllerAdvice(annotations = RestController.class)
public class exceptionConfig {
    @ExceptionHandler(NotFoundUrlException.class)
    public ResponseEntity<?> NotFoundBlogException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
