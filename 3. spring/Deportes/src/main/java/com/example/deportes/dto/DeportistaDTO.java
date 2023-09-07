package com.example.deportes.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistaDTO {

    private String nombre;
    private String apellido;
    private String deporte;

}
