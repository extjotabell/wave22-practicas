package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {

    private int id;
    private String nombre;
    private String autor;
    private Date fecha;

}

