package com.calculadoraCalorias.CalculadoraCalorias.service;

import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishCaloriesDTO;
import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishDTO;
import com.calculadoraCalorias.CalculadoraCalorias.models.Food;

import java.util.List;

public interface ICaloriesService {
    DishCaloriesDTO calculateDish(DishDTO dish);
}
