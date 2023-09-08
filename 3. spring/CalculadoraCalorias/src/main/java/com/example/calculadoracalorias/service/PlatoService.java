package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.dto.PlatoDTO;
import com.example.calculadoracalorias.model.Ingrediente;
import com.example.calculadoracalorias.model.Plato;
import com.example.calculadoracalorias.repository.PlatosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class PlatoService {
    @Autowired
    private PlatosRepository platosRepository;


    public Integer getCaloriasPlato(String name, Integer peso) {
        Plato p = platosRepository.getPlatoByName(name);
        return new ModelMapper().map(p, PlatoDTO.class).getCalories() * peso/100;
    }

    public List<IngredienteDTO> getCaloriasIngredientes(String name, Integer peso) {
        Plato p = platosRepository.getPlatoByName(name);
        List<Ingrediente> ing = p.getIngredientes();
        int pesoPorIng = peso / ing.size();

        return ing
                .stream()
                .map(
                        ingrediente -> new IngredienteDTO(
                                ingrediente.getName(),
                                ingrediente.getCalories() * 100 / pesoPorIng))
                .collect(Collectors.toList());
    }

    public IngredienteDTO getCaloriasMax(String name, Integer peso){
        List<IngredienteDTO> ingredientes = this.getCaloriasIngredientes(name, peso);
        return Collections.max(ingredientes, Comparator.comparingInt(IngredienteDTO::getCalories));
    }
}
