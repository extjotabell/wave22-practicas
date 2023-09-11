package com.sistemaEstudiantes.sistemaEstudiantes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String lastname;
    private long dni;
}
