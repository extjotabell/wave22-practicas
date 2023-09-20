package com.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDto {
    private String explanation;
    private List<String> messages;
}
