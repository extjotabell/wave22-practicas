package com.meli.calculadoracalorias.service.impl;

import com.meli.calculadoracalorias.dto.PlatoDTO;
import com.meli.calculadoracalorias.model.Ingredient;
import com.meli.calculadoracalorias.model.Plato;
import com.meli.calculadoracalorias.repository.PlatoRepository;
import com.meli.calculadoracalorias.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Autowired
    private PlatoRepository repository;
    @Override
    public Double getCaloriasTotales(String name, Double peso) {
        return repository.getPlato(name, peso).getIngredients().stream().mapToDouble(o -> o.getCalories()).sum();
    }

}
