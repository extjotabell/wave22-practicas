package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDto {
    private Integer id;
    private String tituloBlog, nombreAutor, fechaPublicacion;
}