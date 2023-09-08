package com.calculadoraCalorias.CalculadoraCalorias.repository;

import com.calculadoraCalorias.CalculadoraCalorias.models.Food;

import java.util.Optional;

public interface ICaloriesRepository {
    Food ingredientsInDish(String name);
}
