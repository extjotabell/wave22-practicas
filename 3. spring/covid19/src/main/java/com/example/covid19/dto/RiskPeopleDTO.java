package com.example.covid19.dto;

import com.example.covid19.model.Symptom;

import java.util.List;

public class RiskPeopleDTO {
    private String name;
    private List<Symptom> symptoms;

    public RiskPeopleDTO(String name, List<Symptom> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "RiskPeopleDTO{" +
                "name='" + name + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}
