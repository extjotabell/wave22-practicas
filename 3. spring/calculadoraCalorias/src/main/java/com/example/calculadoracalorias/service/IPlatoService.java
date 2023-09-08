package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.FoodDTO;
import com.example.calculadoracalorias.dto.PlatoDTO;
import com.example.calculadoracalorias.model.Plato;

import java.util.List;

public interface IPlatoService {

    PlatoDTO getCaloriasByName(String name);
    FoodDTO getFoodConMayorCalorias(String name);



}
