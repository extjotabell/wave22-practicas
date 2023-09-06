package com.practico.deportistas.dto;

import com.practico.deportistas.model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String Nombre;
    private String Apellido;
    private DeportesDTO deporte;
}
