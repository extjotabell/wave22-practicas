package com.spring.calculadora_de_calorias.web.mappers;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.web.dto.IngredienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredienteMapper {
    Ingrediente toEntity(IngredienteDTO ingredienteDTO);
    IngredienteDTO toDto(Ingrediente ingrediente);
}
