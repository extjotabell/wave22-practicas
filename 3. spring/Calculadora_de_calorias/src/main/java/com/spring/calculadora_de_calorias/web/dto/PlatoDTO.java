package com.spring.calculadora_de_calorias.web.dto;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String name;
    private Double peso;
    private List<Ingrediente> ingrediente;
}
