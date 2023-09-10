package com.example.Covid19.controller;

import com.example.Covid19.dto.SymptomDTO;
import com.example.Covid19.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SymptomController {

    @Autowired
    ISymptomService symptomService;

    @GetMapping("findSymptoms")
    public ResponseEntity<List<SymptomDTO>> getAllSymptoms(){
        List<SymptomDTO> symptoms = symptomService.getAllSymptoms();
        return new ResponseEntity<>(symptoms, HttpStatus.OK);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<SymptomDTO> getSymptomByName(@PathVariable String name){
        SymptomDTO symptom = symptomService.getSymptomByName(name);
        return new ResponseEntity<>(symptom, HttpStatus.OK);
    }

}
