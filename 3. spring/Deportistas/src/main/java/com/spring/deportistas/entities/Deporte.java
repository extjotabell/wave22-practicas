package com.spring.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Deporte {
    private String nombre;
    private Nivel nivel;
}
