package com.example.blogs.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException() {

    }

    public BlogNotFoundException(String message){
        super(message);
    }
}
