package com.example.Covid19.service;

import com.example.Covid19.dto.PatientDTO;
import com.example.Covid19.model.Patient;
import com.example.Covid19.repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService{

    @Autowired
    IPatientRepo patientRepo;

    @Override
    public List<PatientDTO> getRiskPatients() {
        List<Patient> repoResponse = patientRepo.getAllRiskPatients();
        List<PatientDTO> riskPatients = new ArrayList<>();
        for (Patient p :
                repoResponse) {
            riskPatients.add(new PatientDTO(String.format("%s %s", p.getName(), p.getLastName()), p.getSymptomList()));
        }
         return riskPatients;
    }
}
