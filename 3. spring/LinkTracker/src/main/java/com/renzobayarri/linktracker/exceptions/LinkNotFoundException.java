package com.renzobayarri.linktracker.exceptions;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(int id) {
        super("The link with id " + id + " doesn't exist");
    }

}
