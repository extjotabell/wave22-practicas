package com.example.ejerciciocomida.service;

import com.example.ejerciciocomida.dto.FoodDto;

import java.util.List;

public interface IFoodService {

    Integer getCantidadTotalCalorias();
    List<FoodDto> getListadoIngredientes();
    FoodDto getIngredienteMayorCantidadCalorias();
}
