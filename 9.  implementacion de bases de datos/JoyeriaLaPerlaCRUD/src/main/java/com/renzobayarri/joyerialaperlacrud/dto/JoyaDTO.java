package com.renzobayarri.joyerialaperlacrud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoyaDTO {

    @Null(message = "El id de la joya se genera de forma automática")
    private Long id;

    @NotBlank(message = "Indicar un nombre")
    private String nombre;

    @NotBlank(message = "Indicar el material")
    private String material;

    @NotNull(message = "Indicar el peso en gramos")
    @Positive(message = "El peso en gramos debe ser un valor positivo")
    private Double peso;

    private String particularidad;

    @NotNull(message = "Indicar si la joya posee o no piedra")
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    @AssertTrue(message = "Para eliminar una joya, ingrese a /delete/{id}")
    private Boolean ventaONo;
}
