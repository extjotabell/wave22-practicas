package com.example.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Symptom {
    private int id;
    private String name;
    private int severity;
}
