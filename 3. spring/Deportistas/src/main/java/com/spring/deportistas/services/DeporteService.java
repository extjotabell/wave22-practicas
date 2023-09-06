package com.spring.deportistas.services;

import com.spring.deportistas.entities.Deporte;
import com.spring.deportistas.web.dto.DeporteDTO;

import java.util.List;

public interface DeporteService {
    List<DeporteDTO> findSports();
    Deporte findSportByName(String name);
}
