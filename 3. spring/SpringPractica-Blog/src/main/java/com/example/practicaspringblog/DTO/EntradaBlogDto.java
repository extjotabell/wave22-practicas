package com.example.practicaspringblog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
