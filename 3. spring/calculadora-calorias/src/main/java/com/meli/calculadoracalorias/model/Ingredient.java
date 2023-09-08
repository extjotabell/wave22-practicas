package com.meli.calculadoracalorias.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;
}
