package com.example.covid19.Controller;

import com.example.covid19.DTO.PersonaRiesgoDTO;
import com.example.covid19.Service.PersonasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class RiskPersonController {
    private final PersonasService personasService = new PersonasService();

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDTO>> getRiskPeople(){
        return new ResponseEntity<>(this.personasService.findRiskPersons(), HttpStatus.OK);
    }
}
