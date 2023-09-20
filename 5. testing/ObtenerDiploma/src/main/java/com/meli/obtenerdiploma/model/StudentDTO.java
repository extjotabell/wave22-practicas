package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre del estudiante es obligatorio")
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Size( max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z].*", message="El nombre del alumno debe comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;
    @NotNull(message = "La lista materia es obligatoria.")
    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}
