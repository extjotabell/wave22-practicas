package com.restaurant.calories.service;

import com.restaurant.calories.dto.DishDetailsDTO;
import org.springframework.stereotype.Service;

public interface IDishDetailService {
    public DishDetailsDTO getDishDetailsDTO(String name, double weight);
}
