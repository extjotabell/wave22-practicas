package com.sistemaEstudiantes.sistemaEstudiantes.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String lastname;
    private long dni;
}
