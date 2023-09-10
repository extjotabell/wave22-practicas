package com.example.Covid19.service;

import com.example.Covid19.dto.SymptomDTO;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTO> getAllSymptoms();
    SymptomDTO getSymptomByName(String name);
}
