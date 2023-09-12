package com.covid.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private List<SintomaDto> sintomaList;


}
