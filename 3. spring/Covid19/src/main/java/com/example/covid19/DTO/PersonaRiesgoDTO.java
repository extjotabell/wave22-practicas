package com.example.covid19.DTO;

import com.example.covid19.Model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRiesgoDTO {
    private String nombre;
    private Integer edad;
    private List<Sintoma> sintomaList;
}
