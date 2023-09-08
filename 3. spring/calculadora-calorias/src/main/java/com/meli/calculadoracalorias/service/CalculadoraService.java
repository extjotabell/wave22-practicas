package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.dto.PlatoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CalculadoraService {
    Double getCaloriasTotales(String name, Double peso);
}
