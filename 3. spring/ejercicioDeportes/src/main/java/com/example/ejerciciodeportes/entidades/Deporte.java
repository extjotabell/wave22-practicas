package com.example.ejerciciodeportes.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Deporte {
    private String nombre;
    private int nivel;
}
