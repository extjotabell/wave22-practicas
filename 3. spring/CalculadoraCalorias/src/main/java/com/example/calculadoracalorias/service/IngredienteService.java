package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.repository.IngredientesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {
    @Autowired
    private IngredientesRepository ingredientesRepository;
    public List<IngredienteDTO> getAllIngredientes(){
        return ingredientesRepository.getAllIngredientes()
                .stream()
                .map(ingrediente -> new ModelMapper().map(ingrediente, IngredienteDTO.class))
                .collect(Collectors.toList());
    }
}
