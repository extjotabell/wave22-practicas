package com.example.ejerciciocalculadoracalorias2.service;

import com.example.ejerciciocalculadoracalorias2.dto.DishRequestDTO;
import com.example.ejerciciocalculadoracalorias2.dto.DishResponseDTO;
import com.example.ejerciciocalculadoracalorias2.dto.IngredientDTO;
import com.example.ejerciciocalculadoracalorias2.model.Ingredient;
import com.example.ejerciciocalculadoracalorias2.repository.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    private IngredientRepository ingredientRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public DishResponseDTO calculateCalories(DishRequestDTO dishRequestDTO) {
        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        dishResponseDTO.setName(dishRequestDTO.getName());
        List<Ingredient> ingredients = dishRequestDTO.getIngredients()
                .stream()
                .map(i -> ingredientRepository.findIngredientByName(i))
                .toList();
        List<IngredientDTO> ingredientsDTO = ingredients.stream()
                .map(i -> mapper.map(i, IngredientDTO.class))
                .toList();
        dishResponseDTO.setIngredients(ingredientsDTO);
        dishResponseDTO.setMaxCaloriesIngredient(ingredientsDTO.stream().max(Comparator.comparing(IngredientDTO::getCalories)).get());
        dishResponseDTO.setTotalCalories(ingredientsDTO.stream().mapToDouble(IngredientDTO::getCalories).sum() * dishRequestDTO.getWeight() / 100);
        return dishResponseDTO;
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories(List<DishRequestDTO> dishRequestDTOS) {
        return dishRequestDTOS.stream().map(d -> calculateCalories(d)).toList();
    }
}
