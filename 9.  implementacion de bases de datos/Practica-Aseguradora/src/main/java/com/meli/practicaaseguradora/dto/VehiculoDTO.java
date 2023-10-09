package com.meli.practicaaseguradora.dto;

import com.meli.practicaaseguradora.model.Siniestro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private String matricula;
    private Integer anioFabricacion;
    private Integer cantRuedas;
    private List<Siniestro> siniestros;

}
