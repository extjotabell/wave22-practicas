package com.example.covid19.controller;

import com.example.covid19.dto.RiskPeopleDTO;
import com.example.covid19.model.Person;
import com.example.covid19.model.Symptom;
import com.example.covid19.repository.PersonRepository;
import com.example.covid19.repository.SymptomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RiskController {

    private final SymptomRepository symptomRepository;
    private final PersonRepository personRepository;

    Map<String, List<Symptom>> symptomsMap = new HashMap<>();
    public RiskController() {
        personRepository = new PersonRepository();
        symptomRepository = new SymptomRepository();
        for (Person person: personRepository.getPeople()) {
            symptomsMap.put(person.getId(), addRandomSymptoms());
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPeopleDTO>> searchRiskPeople() {
        List<Person> peopleOlderThan60 = personRepository.getPeople().stream().filter(person -> person.getAge() >= 60).toList();
        List<RiskPeopleDTO> riskPeopleDTOList = new ArrayList<>();
        for (Person person : peopleOlderThan60) {
            List<Symptom> symptoms = symptomsMap.get(person.getId());
            riskPeopleDTOList.add(new RiskPeopleDTO(person.getName(), symptoms));
        }

        System.out.println(riskPeopleDTOList);

        return new ResponseEntity<>(riskPeopleDTOList, HttpStatus.OK);
    }

    public List<Symptom> addRandomSymptoms() {
        List<Symptom> symptoms = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            symptoms.add(symptomRepository.getSymptoms().get( new Random().nextInt(3)));
        }
        return symptoms;
    }
}
