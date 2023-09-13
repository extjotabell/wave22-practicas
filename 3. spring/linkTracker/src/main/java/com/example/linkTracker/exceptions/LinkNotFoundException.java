package com.example.linkTracker.exceptions;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {

    }
    public LinkNotFoundException(Integer id) {
        super(String.format("Link con el id: %s no fue encontrado", id));
    }
}
