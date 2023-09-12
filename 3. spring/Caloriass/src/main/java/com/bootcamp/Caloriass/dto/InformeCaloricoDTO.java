package com.bootcamp.Caloriass.dto;

import com.bootcamp.Caloriass.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InformeCaloricoDTO {
    private double caloriasTotales;
    private List<Ingrediente> listaDeIngredientesYCalorias;
    private String nombreDelIngredienteMasCalorico;
}
