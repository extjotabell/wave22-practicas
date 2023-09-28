package com.example.be_java_hisp_w22_g05.exception;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String message){
        super(message);
    }
}
