package com.example.ejerciciohql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDTO {

    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer ruedas;

}
