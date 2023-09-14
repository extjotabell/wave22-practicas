package com.bootcampW22.EjercicioGlobal.exception;

import org.slf4j.helpers.BasicMDCAdapter;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
