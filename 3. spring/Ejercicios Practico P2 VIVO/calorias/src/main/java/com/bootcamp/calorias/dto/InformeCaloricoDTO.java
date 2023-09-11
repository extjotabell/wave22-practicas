package com.bootcamp.calorias.dto;

import com.bootcamp.calorias.model.Ingrediente;
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
