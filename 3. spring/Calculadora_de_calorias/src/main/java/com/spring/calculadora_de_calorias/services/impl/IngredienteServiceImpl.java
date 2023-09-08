package com.spring.calculadora_de_calorias.services.impl;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.repositories.IIngredienteRepository;
import com.spring.calculadora_de_calorias.services.IIngredienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class IngredienteServiceImpl implements IIngredienteService {

    private final IIngredienteRepository iIngredienteRepository;
    @Override
    public Map<Ingrediente, Double> getIngredientesYCalorias(String nombrePlato) {
        return iIngredienteRepository.getAllIngredientesAndCalories(nombrePlato);
    }

    @Override
    public Ingrediente getIngredienteConMaxCalorias(String nombrePlato) {
        return iIngredienteRepository.getIngredientWithMaxCalories(nombrePlato);
    }
}
