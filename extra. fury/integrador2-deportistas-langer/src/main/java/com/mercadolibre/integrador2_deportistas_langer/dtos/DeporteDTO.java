package com.mercadolibre.integrador2_deportistas_langer.dtos;

import com.mercadolibre.integrador2_deportistas_langer.model.Deportee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteDTO {
    String name;
    String nivel;

    public DeporteDTO(Deportee deporte){
        this.name = deporte.getNombre();
        this.nivel = deporte.getNivel();
    }
}
