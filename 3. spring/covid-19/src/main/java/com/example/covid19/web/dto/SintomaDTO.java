package com.example.covid19.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDTO {

    private String nombre;
    private String nivel_de_gravedad;

}
