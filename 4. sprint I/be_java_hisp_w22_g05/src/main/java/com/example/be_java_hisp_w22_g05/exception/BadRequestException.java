package com.example.be_java_hisp_w22_g05.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(){

    }

    public BadRequestException(String message){
        super(message);
    }
}
