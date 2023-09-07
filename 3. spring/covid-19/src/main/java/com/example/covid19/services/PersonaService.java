package com.example.covid19.services;

import com.example.covid19.web.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> findRiskPerson();
}
