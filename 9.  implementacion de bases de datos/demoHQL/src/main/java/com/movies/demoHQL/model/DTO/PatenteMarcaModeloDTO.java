package com.movies.demoHQL.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
