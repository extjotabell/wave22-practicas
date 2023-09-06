package com.example.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Deporte {
    private int id;
    private String nombre;
    private int nivel;
}
