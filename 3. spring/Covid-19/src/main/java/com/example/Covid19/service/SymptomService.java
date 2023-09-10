package com.example.Covid19.service;

import com.example.Covid19.dto.SymptomDTO;
import com.example.Covid19.model.Symptom;
import com.example.Covid19.repo.ISymptomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomService implements ISymptomService{
    
    @Autowired
    ISymptomRepo symptomRepo;

    @Override
    public List<SymptomDTO> getAllSymptoms() {
        List<Symptom> repoResponse = symptomRepo.getAllSymptoms();
        List<SymptomDTO> symptomDTOs = new ArrayList<>();
        for (Symptom s :
                repoResponse) {
            symptomDTOs.add(new SymptomDTO(s.getName(), s.getSeverity()));
        }
        return symptomDTOs;
    }

    @Override
    public SymptomDTO getSymptomByName(String name) {
        Symptom symptom = symptomRepo.getSymptomByName(name);
        if(symptom != null)
            return new SymptomDTO(symptom.getName(), symptom.getSeverity());
        return null;
    }
}
