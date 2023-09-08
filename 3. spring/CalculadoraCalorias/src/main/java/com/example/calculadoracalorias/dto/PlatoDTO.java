package com.example.calculadoracalorias.dto;

import com.example.calculadoracalorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDTO {
    private String name;
    private Integer peso;
    private List<IngredienteDTO> ingredientes;
    private Integer calories;
}
