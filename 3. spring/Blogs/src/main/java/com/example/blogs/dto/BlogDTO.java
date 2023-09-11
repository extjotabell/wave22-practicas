package com.example.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BlogDTO {
    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
