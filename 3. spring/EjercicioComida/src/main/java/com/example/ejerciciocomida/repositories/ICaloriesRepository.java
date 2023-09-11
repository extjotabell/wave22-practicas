package com.example.ejerciciocomida.repositories;

import com.example.ejerciciocomida.entities.Ingredient;

import java.util.List;

public interface ICaloriesRepository {
    Integer getCalories(String name);
}
