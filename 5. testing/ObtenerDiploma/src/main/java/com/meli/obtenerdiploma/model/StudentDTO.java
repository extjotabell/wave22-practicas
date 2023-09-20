package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Validated
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;
}
