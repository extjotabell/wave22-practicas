package com.mercadolibre.integrador2_deportistas_langer.dtos;

import lombok.Data;

@Data
public class DeportistaDTO {
    String nombre;
    String apellido;
    String deporte;

    public DeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }


}
