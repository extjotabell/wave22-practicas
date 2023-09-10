package com.example.Covid19.repo;

import com.example.Covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SymptomRepo implements ISymptomRepo{
    private List<Symptom> symptoms;


    public SymptomRepo() {
        this.symptoms = new ArrayList<>();
        this.symptoms.add(new Symptom(1, "Fever", 1));
        this.symptoms.add(new Symptom(2, "No smell", 3));
        this.symptoms.add(new Symptom(3, "No flavor", 2));
        this.symptoms.add(new Symptom(4, "Shortness of breath", 1));
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return this.symptoms;
    }

    @Override
    public Symptom getSymptomByName(String name) {
        Symptom symptom = this.symptoms.stream().filter(s -> Objects.equals(s.getName(), name)).findFirst().orElse(null);
        return symptom;
    }
}
