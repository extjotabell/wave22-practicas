package com.example.Covid19.service;

import com.example.Covid19.dto.PatientDTO;
import com.example.Covid19.dto.SymptomDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> getRiskPatients();

}
