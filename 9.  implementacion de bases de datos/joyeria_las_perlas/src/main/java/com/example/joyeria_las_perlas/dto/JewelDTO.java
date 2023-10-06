package com.example.joyeria_las_perlas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JewelDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long nroIdentificatorio;

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
