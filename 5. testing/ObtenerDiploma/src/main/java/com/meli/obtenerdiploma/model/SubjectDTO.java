package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @NotBlank(message ="El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;
    @Min(value = 0, message = "el valor minimo es 0")
    @Max(value = 10, message = "el valor maximo es 10")
    Double score;
}
