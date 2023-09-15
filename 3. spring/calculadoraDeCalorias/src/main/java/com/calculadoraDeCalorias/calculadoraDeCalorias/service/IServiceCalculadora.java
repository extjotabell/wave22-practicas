package com.calculadoraDeCalorias.calculadoraDeCalorias.service;

import com.calculadoraDeCalorias.calculadoraDeCalorias.dto.DishDto;

public interface IServiceCalculadora {
    DishDto getDish(String name, double weight);
}
