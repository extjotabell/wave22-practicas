package com.example.ejerciciocomida.services;

import com.example.ejerciciocomida.dtos.CaloriasDto;
import com.example.ejerciciocomida.dtos.IngredientDto;

import java.util.List;

public interface IDishesService {
    CaloriasDto getCalories(String name, Integer weigth);
    List<IngredientDto> getListIngredient(String name);

    IngredientDto getWorstIngredient(String name);
}
