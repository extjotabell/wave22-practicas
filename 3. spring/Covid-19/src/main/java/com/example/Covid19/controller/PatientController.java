package com.example.Covid19.controller;

import com.example.Covid19.dto.PatientDTO;
import com.example.Covid19.model.Patient;
import com.example.Covid19.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    IPatientService patientService;
    @GetMapping("/riskPatients")
    public ResponseEntity<List<PatientDTO>> getAllRiskPatients(){
        return new ResponseEntity<>(patientService.getRiskPatients(), HttpStatus.OK);
    }


}
