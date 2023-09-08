package com.introduccionspring.blog.exceptions;

public class IdAlreadyTakenException extends RuntimeException {

    public IdAlreadyTakenException(){

    }
    public IdAlreadyTakenException(Long id) {
        super(String.format("The id: %s is already taken", id));
    }
}
