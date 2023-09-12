package com.renzobayarri.calcularcalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDTO {

    private String nombre;

    private int calorias;

}
