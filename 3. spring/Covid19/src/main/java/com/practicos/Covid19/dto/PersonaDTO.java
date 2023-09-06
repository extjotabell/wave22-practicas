package com.practicos.Covid19.dto;

import com.practicos.Covid19.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO {
    private String nombre;
    private Integer edad;
    private List<Sintoma> sintomaList;
}
