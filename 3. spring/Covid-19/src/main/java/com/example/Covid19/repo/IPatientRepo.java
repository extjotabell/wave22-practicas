package com.example.Covid19.repo;

import com.example.Covid19.model.Patient;

import java.util.List;

public interface IPatientRepo {
    List<Patient> getAllPatients();
    List<Patient> getAllRiskPatients();


}
