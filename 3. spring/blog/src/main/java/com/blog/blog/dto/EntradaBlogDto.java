package com.blog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String autor;
    private String fechaDePublicacion;
}
