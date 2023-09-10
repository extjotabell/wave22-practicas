package com.example.Covid19.repo;

import com.example.Covid19.model.Patient;
import com.example.Covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PatientRepo implements IPatientRepo {

    private List<Patient> patients;

    public PatientRepo() {
        this.patients = new ArrayList<>();
        List<Symptom> symp = new ArrayList<>();
        List<Symptom> symp2 = new ArrayList<>();
        symp.add(new Symptom(2, "No Smell", 3));
        symp2.add(new Symptom(1, "Fever", 1));
        symp2.add(new Symptom(4, "Shortness of breath", 1));
        this.patients.add(new Patient(1, "Magui", "Cagna", 25, symp));
        this.patients.add(new Patient(2, "Pepito", "Perez", 60, symp2));
        this.patients.add(new Patient(2, "Maria", "Gonzalez", 60, symp));
    }


    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public List<Patient> getAllRiskPatients() {
        return this.patients.stream().filter(p -> p.getAge() >= 60).collect(Collectors.toList());
    }
}
