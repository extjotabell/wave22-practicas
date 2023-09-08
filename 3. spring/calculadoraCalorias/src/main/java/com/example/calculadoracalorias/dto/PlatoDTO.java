package com.example.calculadoracalorias.dto;

import com.example.calculadoracalorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PlatoDTO {


    private String nombre;
    private List<Food> ingredientes;
    private int totalCalorias;
}
