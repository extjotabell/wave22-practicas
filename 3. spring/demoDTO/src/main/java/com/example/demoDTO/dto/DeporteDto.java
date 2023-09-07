package com.example.demoDTO.dto;

import com.example.demoDTO.model.Deporte;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeporteDto {

    private String nombre;
    private String nivel;

    public DeporteDto(Deporte deporte) {
        this.nombre = deporte.getNombre();
        this.nivel = deporte.getNivel();
    }

    public DeporteDto() {
    }

    @Override
    public String toString() {
        return "DeporteDto{" +
                "nombre='" + nombre + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}
