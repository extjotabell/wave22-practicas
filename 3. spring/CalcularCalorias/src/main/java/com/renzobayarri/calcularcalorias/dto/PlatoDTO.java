package com.renzobayarri.calcularcalorias.dto;

import com.renzobayarri.calcularcalorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {

    private String nombre;

    private double calorias;

    private List<IngredienteDTO> ingredientes;

    private String ingredienteMayorCalorias;

}
