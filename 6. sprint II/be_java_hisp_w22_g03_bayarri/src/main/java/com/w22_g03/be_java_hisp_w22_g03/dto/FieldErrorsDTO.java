package com.w22_g03.be_java_hisp_w22_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FieldErrorsDTO {

    private List<String> errors;
}
