package com.renzobayarri.joyerialaperlacrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorsDTO {

    private List<String> errors;

}
