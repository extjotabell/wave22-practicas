package com.example.covid19.services;

import com.example.covid19.models.Sintoma;
import com.example.covid19.web.dto.SintomaDTO;

import java.util.List;

public interface SintomaServices {

    List<SintomaDTO> findSymptom();
    Sintoma findSymptomByName(String nombre);

}
