package com.covid19.covid19.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private String nombre;
    private int nivel_de_gravedad;
}
