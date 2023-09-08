package com.introduccionspring.blog.exceptions;

import com.introduccionspring.blog.entities.EntradaBlog;

public class EntradaBlogNotFoundException extends RuntimeException {

    public EntradaBlogNotFoundException() {

    }
    public EntradaBlogNotFoundException(Long id) {
        super(String.format("User with id: %s not found", id));
    }
}
