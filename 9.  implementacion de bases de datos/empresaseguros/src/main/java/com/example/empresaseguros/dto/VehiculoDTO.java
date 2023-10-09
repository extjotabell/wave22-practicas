package com.example.empresaseguros.dto;

import com.example.empresaseguros.entity.Siniestro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class VehiculoDTO {

    @JsonIgnore
    private Integer id_vehiculo;

    private String patente;
    private String marca;
    private String modelo;
    private LocalDate añoFabricacion;
    private int cantidadRuedas;
    private List<Siniestro> siniestros;
}
