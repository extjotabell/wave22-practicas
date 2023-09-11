package com.example.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SintomaDTO {
    public String nombre;
    public Integer nivelGravedad;
}
