package com.spring.calculadora_de_calorias.web.mappers;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.entities.Plato;
import com.spring.calculadora_de_calorias.web.dto.IngredienteDTO;
import com.spring.calculadora_de_calorias.web.dto.PlatoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlatoMapper {
    Plato toEntity(PlatoDTO platoDTO);
    PlatoDTO toDto(Plato plato);
}
