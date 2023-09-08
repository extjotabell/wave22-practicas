package com.spring.calculadora_de_calorias.repositories;

import com.spring.calculadora_de_calorias.entities.Ingrediente;

import java.util.Map;

public interface IIngredienteRepository {
    Map<Ingrediente, Double> getAllIngredientesAndCalories(String nombrePlato);
    Ingrediente getIngredientWithMaxCalories(String nombrePlato);
}
