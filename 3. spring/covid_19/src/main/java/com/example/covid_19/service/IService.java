package com.example.covid_19.service;

import com.example.covid_19.dto.GravedadDTO;
import com.example.covid_19.dto.SintomaDTO;
import com.example.covid_19.dto.SintomasDTO;

import java.util.List;

public interface IService {

    List<SintomaDTO> getSintomas();

    GravedadDTO obtenerGravedadSintoma(SintomaDTO sintoma);
    void setSintomas(SintomasDTO sintomas);
}
