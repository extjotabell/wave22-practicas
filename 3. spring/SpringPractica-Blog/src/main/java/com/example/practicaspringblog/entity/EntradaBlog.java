package com.example.practicaspringblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
