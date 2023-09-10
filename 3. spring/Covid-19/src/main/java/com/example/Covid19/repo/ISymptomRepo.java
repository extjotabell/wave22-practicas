package com.example.Covid19.repo;

import com.example.Covid19.model.Symptom;

import java.util.List;

public interface ISymptomRepo {
    List<Symptom> getAllSymptoms();
    Symptom getSymptomByName(String name);


}
