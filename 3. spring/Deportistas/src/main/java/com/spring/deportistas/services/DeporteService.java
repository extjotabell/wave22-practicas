package com.spring.deportistas.services;

import com.spring.deportistas.entities.Deporte;

import java.util.List;

public interface DeporteService {
    List<Deporte> findSports();
    Deporte findSportByName(String name);
}
