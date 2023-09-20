package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@Validated
public class StudentDTO {

    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @NotNull(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;

    String message;
    Double averageScore;

    List<@Valid SubjectDTO> subjects;
}
