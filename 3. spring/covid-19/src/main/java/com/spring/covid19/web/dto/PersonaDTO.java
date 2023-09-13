package com.spring.covid19.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class PersonaDTO {
    private String nombre;
    private String apellido;
    private String sintomaAsociado;
}