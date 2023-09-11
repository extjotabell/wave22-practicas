package com.ejercicios.calculadoracalorias.dtos;

import com.ejercicios.calculadoracalorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {

    private List<Food> listaFood;
}