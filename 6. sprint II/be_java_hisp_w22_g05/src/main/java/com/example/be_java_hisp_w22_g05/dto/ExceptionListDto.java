package com.example.be_java_hisp_w22_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionListDto {
    private String explanation;
    private List<String> messages;
}
