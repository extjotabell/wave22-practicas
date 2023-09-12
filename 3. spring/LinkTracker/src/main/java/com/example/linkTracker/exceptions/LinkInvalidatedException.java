package com.example.linkTracker.exceptions;

public class LinkInvalidatedException extends RuntimeException{
    public LinkInvalidatedException(){

    }
    public LinkInvalidatedException(Integer id) {
        super(String.format("El link al que intenta redirigir ha sido invalidado", id));
    }
}
