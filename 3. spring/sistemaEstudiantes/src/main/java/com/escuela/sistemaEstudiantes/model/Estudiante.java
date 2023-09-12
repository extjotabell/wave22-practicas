package com.escuela.sistemaEstudiantes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private int estudianteId;
    private String nombre;
    private String apellido;
    private int dni;

}
