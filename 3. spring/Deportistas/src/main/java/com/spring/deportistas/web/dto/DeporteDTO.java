package com.spring.deportistas.web.dto;

import com.spring.deportistas.entities.Nivel;
import lombok.Data;

@Data
public class DeporteDTO {
    private String nombre;
    private Nivel nivel;
}
