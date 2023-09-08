package com.example.blog.exception;

public class BlogNotFound extends RuntimeException {
    public BlogNotFound(String message) {
        super(message);
    }
}
