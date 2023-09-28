package com.example.be_java_hisp_w22_g05.exception;

public class RequestParamInvalidException extends RuntimeException{

    public RequestParamInvalidException(){

    }
     public RequestParamInvalidException(String message){
        super(message);
     }

}
