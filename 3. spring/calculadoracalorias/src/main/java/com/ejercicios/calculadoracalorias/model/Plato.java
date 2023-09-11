package com.ejercicios.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private List<Food> listaFood;
}
