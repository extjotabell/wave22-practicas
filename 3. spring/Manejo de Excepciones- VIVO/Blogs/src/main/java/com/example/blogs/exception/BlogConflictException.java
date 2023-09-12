package com.example.blogs.exception;

public class BlogConflictException extends RuntimeException {

    public BlogConflictException() {

    }

    public BlogConflictException(String message){
        super(message);
    }
}