package com.example.be_java_hisp_w22_g05.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }

}
