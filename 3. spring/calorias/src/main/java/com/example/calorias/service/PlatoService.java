package com.example.calorias.service;

import com.example.calorias.dto.PlatoDTO;
import com.example.calorias.dto.PlatoRespuestaDTO;

import java.util.List;

public interface PlatoService {
    PlatoRespuestaDTO calcularCalorias(PlatoDTO plato);

}
