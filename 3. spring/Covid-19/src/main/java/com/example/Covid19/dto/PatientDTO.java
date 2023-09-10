package com.example.Covid19.dto;

import com.example.Covid19.model.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private String fullName;
    private List<Symptom> symptoms;
 }
