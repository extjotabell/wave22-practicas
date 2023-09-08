package com.meli.calculadoracalorias.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String name;
    private List<Ingredient> ingredients;
    private Double weight;
}
