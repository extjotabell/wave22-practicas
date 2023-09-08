package com.example.blogs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
