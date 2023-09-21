package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @NotBlank(message ="El nombre del alumno no puede estar vacío.")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message ="El nombre de la materia no puede estar vacío.")
    List<@Valid SubjectDTO> subjects;
}
