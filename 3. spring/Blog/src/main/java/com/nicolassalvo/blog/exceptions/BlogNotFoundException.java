package com.nicolassalvo.blog.exceptions;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(int id) {
        super("There are no blogs with id " + id);
    }
}
