package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter @Setter
@Validated
public class SubjectDTO {

    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @NotNull(message = "El nombre del materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "El nombre de la materia debe comenzar con mayúscula")
    String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @DecimalMax(value = "10", message = "La máxima nota es 10.")
    @DecimalMin(value= "0", message = "La mínima nota es 0.")
    Double score;

}
