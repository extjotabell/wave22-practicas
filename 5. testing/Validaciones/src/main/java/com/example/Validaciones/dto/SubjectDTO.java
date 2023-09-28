package com.example.Validaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDTO {
    @NotNull(message = "Student name can't be empty/blank")
    @Pattern(regexp = "\\b[A-Z].*?\\b", message = "Names have to start with upper case")
    @Length(max = 50, message = "Names have to be shorter than 50 characters")
    private String name;
    @NotNull
    @Min(value = 0, message = "The lowest grade allowed is 0.0")
    @Max(value = 10, message = "The highest grade allowed is 10.0")
    private double score;

}
