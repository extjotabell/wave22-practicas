package com.escuela.sistemaEstudiantes.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private int estudianteId;
    private String nombre;
    private String apellido;
    private int dni;

}