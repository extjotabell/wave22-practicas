package com.spring.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private Nivel nivel;
}
