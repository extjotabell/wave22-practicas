package com.spring.deportistas.web.dto;

import com.spring.deportistas.entities.Nivel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeporteDTO {
    private String nombre;
    private Nivel nivel;
}
