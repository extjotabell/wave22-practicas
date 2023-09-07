package com.example.covid19.dto;

import com.example.covid19.model.SeverityLevel;
import lombok.Getter;
@Getter
public class SymptomDTO {
    private String name;
    private SeverityLevel severityLevel;

    public SymptomDTO(String name, SeverityLevel severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
