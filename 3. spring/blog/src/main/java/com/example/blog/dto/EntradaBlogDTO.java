package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String nombre;
    private String autor;
    private String fecha;
}
