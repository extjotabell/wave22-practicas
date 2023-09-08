package com.example.blog.exception;

public class NoBlogsCreated extends RuntimeException{
    public NoBlogsCreated(String message) {
        super(message);
    }
}
