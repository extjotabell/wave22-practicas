package com.bootcamp.deportistas.DTO;

import com.bootcamp.deportistas.model.Deportee;
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
