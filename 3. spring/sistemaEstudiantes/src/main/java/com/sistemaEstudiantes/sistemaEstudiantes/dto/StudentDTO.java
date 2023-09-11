package com.sistemaEstudiantes.sistemaEstudiantes.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String name;
    private String lastname;
    private long dni;
}
