package com.example.ejercicioblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaDePublicacion;
}
