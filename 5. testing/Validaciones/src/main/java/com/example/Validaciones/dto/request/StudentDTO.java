package com.example.Validaciones.dto.request;

import com.example.Validaciones.dto.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int id;
    @NotBlank(message = "Student name can't be empty/blank")
    @Pattern(regexp = "\\b[A-Z].*?\\b", message = "Names have to start with upper case")
    @Size(max = 50, message = "Names have to be shorter than 50 characters")
    private String studentName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double averageScore;
    @NotEmpty(message = "Subject list can't be empty")
    private List<SubjectDTO> subjects;

}
