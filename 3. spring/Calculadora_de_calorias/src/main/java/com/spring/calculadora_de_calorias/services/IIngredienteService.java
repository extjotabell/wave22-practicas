package com.spring.calculadora_de_calorias.services;

import com.spring.calculadora_de_calorias.entities.Ingrediente;

import java.util.Map;

public interface IIngredienteService {
    Map<Ingrediente, Double> getIngredientesYCalorias(String nombrePlato);
    Ingrediente getIngredienteConMaxCalorias(String nombrePlato);
}
