package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearEntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
