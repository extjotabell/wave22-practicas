package com.practicos.Covid19.controller;

import com.practicos.Covid19.dto.PersonaDTO;
import com.practicos.Covid19.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class RiskPersonController {
    private final PersonaService personasService = new PersonaService();

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> getRiskPeople(){
        return new ResponseEntity<>(this.personasService.findRiskPersons(), HttpStatus.OK);
    }
}
