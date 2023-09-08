package com.renzobayarri.blog.exceptions;

public class IdAlreadyExistsException extends RuntimeException {

    public IdAlreadyExistsException(int id) {
        super("Id already exists in a blog " + id);
    }
}
