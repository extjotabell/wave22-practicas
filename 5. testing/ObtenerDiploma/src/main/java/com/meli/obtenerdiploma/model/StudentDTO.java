package com.meli.obtenerdiploma.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía")
    List<@Valid SubjectDTO> subjects;
}
