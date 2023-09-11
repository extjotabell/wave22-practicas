package com.restaurant.calories.service;

import com.restaurant.calories.dto.DishDetailsDTO;
import com.restaurant.calories.repository.IDishDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishDetailService implements IDishDetailService{
    @Autowired
    IDishDetailRepository repo;

    @Override
    public DishDetailsDTO getDishDetailsDTO(String name, double weight) {
        
    }
}
