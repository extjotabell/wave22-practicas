package com.meli.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class JoyaDTO {
    private String nombre;
    private String material;
    private double weight;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
