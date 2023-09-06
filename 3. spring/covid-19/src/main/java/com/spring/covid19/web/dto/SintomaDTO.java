package com.spring.covid19.web.dto;

import com.spring.covid19.entities.Gravedad;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class SintomaDTO {
    private String codigo;
    private String nombre;
    private Gravedad gravedad;
}
