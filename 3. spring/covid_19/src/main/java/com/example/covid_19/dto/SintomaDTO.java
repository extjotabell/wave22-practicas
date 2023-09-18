package com.example.covid_19.dto;


import lombok.*;

@Data
@AllArgsConstructor
public class SintomaDTO {

    String codigo;
    String nombre;
    Integer nivel_de_gravedad;

    public SintomaDTO() {
    }
}
