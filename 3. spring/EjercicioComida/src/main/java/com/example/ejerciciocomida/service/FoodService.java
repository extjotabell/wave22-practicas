package com.example.ejerciciocomida.service;

import com.example.ejerciciocomida.dto.FoodDto;
import com.example.ejerciciocomida.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    IFoodRepository foodRepository;

    public Integer getCantidadTotalCalorias(){
        return null;
    }

    @Override
    public List<FoodDto> getListadoIngredientes() {
        return null;
    }

    @Override
    public FoodDto getIngredienteMayorCantidadCalorias() {
        return null;
    }

}
