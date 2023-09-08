package com.example.ejerciciocalculadoracalorias2.service;

import com.example.ejerciciocalculadoracalorias2.dto.DishRequestDTO;
import com.example.ejerciciocalculadoracalorias2.dto.DishResponseDTO;

import java.util.List;

public interface IDishService {

    DishResponseDTO calculateCalories(DishRequestDTO dishRequestDTO);
    List<DishResponseDTO> calculateAllCalories(List<DishRequestDTO> dishRequestDTOS);
}
