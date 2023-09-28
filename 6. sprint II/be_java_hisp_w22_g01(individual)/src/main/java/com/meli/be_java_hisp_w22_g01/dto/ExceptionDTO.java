package com.meli.be_java_hisp_w22_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ExceptionDTO {


    private List<String> message;


    public ExceptionDTO(List<String> message) {
        this.message = message;
    }

    public ExceptionDTO(String message) {
        this.message = Collections.singletonList(message);
    }
}
