package com.example.calorias.repositories;

import com.example.calorias.dto.IngredienteDTO;

public interface IngredientRepository {
  IngredienteDTO findIngredientByName(String name);
}
