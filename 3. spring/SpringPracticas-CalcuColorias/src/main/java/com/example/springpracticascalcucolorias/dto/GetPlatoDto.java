package com.example.springpracticascalcucolorias.dto;

import com.example.springpracticascalcucolorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class GetPlatoDto {
    private int totalCalorias;
    private List<Ingrediente> listaIngredientes;
    private Ingrediente mayorIndiceCalorico;

    public GetPlatoDto(int totalCalorias, List<Ingrediente> listaIngredientes) {
        this.totalCalorias = totalCalorias;
        this.listaIngredientes = listaIngredientes;
        this.mayorIndiceCalorico = encontrarMayorIndiceCalorico(listaIngredientes);
    }

    private Ingrediente encontrarMayorIndiceCalorico(List<Ingrediente> ingredientes) {
        return ingredientes.stream()
                .max(Comparator.comparingInt(Ingrediente::getCalories))
                .orElse(null);
    }


}
