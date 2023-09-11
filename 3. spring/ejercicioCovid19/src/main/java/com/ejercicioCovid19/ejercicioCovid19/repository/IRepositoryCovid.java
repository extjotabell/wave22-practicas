package com.ejercicioCovid19.ejercicioCovid19.repository;

import com.ejercicioCovid19.ejercicioCovid19.model.Persona;
import com.ejercicioCovid19.ejercicioCovid19.model.Sintoma;

import java.util.List;

public interface IRepositoryCovid {
    void loadDatabase();
    List<Sintoma> getAllSintomas();
    List<Persona> getAllPersonas();
}
