package com.deportista.deportista.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    public String nombre;
    public String apellido;
    public String deporteNombre;
}
