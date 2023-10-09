package com.example.ejerciciohql.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoResponseDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer ruedas;
    private List<SiniestroResponseDTO> siniestros;

    public VehiculoResponseDTO(String patente) {
        this.patente = patente;
    }

    public VehiculoResponseDTO(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }
}
