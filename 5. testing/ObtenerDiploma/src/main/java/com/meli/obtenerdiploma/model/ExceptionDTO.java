package com.meli.obtenerdiploma.model;

import lombok.Data;

import java.util.List;
@Data
public class ExceptionDTO extends RuntimeException {
    public ExceptionDTO(String message) {
        super(message);
    }
}
