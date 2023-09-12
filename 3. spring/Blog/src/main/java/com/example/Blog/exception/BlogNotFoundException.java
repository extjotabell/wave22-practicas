package com.example.Blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "No existe ese blog")
public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(String message){
        super(message);
    }
}
