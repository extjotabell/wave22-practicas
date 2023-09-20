package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.time.DurationMax;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia es obligatorio")
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMin(value = "0.1",message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0",message = "La máxima nota es 10.0.")
    Double score;
}
