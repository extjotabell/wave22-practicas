package com.linkTracker.LinkTracker.exceptions;

import com.linkTracker.LinkTracker.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(NotActiveUrl.class)
    public ResponseEntity<ExceptionDTO> handleNotActiveUrl(NotActiveUrl notActiveUrl){
        return new ResponseEntity<>(new ExceptionDTO(notActiveUrl.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotPermission.class)
    public ResponseEntity<ExceptionDTO> handleNotPermission(NotPermission notPermission){
        return new ResponseEntity<>(new ExceptionDTO(notPermission.getMessage()), HttpStatus.UNAUTHORIZED);
    }

}
