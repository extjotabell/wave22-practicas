package com.covid.covid19.dto;

import com.covid.covid19.Entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDto {
    private String nombre;
    private String nivelDegravedad;


}
