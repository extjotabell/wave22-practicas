package com.example.sistemaestudiantes.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
// @Data // Trae getters setters equals toString, etcetc
@Getter
@Setter
public class Estudiante {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;

}
