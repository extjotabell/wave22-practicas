package com.example.sistemaestudiantes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
// @Data // Trae getters setters equals toString, etcetc
@Getter
@Setter
public class EstudianteDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
}
