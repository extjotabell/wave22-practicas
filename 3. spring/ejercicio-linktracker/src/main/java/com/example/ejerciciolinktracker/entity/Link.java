package com.example.ejerciciolinktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Link {

    private int id;
    private String url;
    private int contador;
    private String password;
    private boolean activo;
}
