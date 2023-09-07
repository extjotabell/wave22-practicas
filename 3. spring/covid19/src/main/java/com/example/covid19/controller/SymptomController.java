package com.example.covid19.controller;

import com.example.covid19.dto.SymptomDTO;
import com.example.covid19.model.Symptom;
import com.example.covid19.repository.SymptomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("findSymptom")
public class SymptomController {
    private SymptomRepository symptomRepository;

    public SymptomController() {
        symptomRepository = new SymptomRepository();
    }

    @GetMapping()
    public ResponseEntity<List<SymptomDTO>> getAllSymptoms() {
        List<SymptomDTO> symptomDTOList = new ArrayList<>();
        for (Symptom symptom : symptomRepository.getSymptoms()) {
            symptomDTOList.add(new SymptomDTO(symptom.getName(), symptom.getSeverityLevel()));
        }
        return new ResponseEntity<>(symptomDTOList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Symptom> getSymptomByName(@PathVariable String name) {
        Symptom foundSymptom = symptomRepository.getSymptoms().stream().filter(symptom -> symptom.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        return new ResponseEntity<>(foundSymptom, HttpStatus.OK);
    }
}
