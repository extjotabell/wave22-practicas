package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre del alumno no puede ser vacio")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La maxima nota es 10.0")
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0")
    Double score;
}
