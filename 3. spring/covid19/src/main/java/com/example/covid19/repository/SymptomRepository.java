package com.example.covid19.repository;

import com.example.covid19.model.SeverityLevel;
import com.example.covid19.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepository {
    private final List<Symptom> symptoms;

    public SymptomRepository() {
        symptoms = new ArrayList<>();
        symptoms.add(new Symptom("Tos", SeverityLevel.MINOR));
        symptoms.add(new Symptom("Perdida de olfato", SeverityLevel.MAJOR));
        symptoms.add(new Symptom("Perdida de gusto", SeverityLevel.MAJOR));
        symptoms.add(new Symptom("Hemorragia interna", SeverityLevel.EXTREME));
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }
}
