package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeportistaDTO {
    public String nombre;
    public String apellido;
    public String deporte;
}
