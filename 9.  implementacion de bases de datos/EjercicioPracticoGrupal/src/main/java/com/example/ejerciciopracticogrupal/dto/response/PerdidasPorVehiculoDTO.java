package com.example.ejerciciopracticogrupal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerdidasPorVehiculoDTO {
    VehiculoDTO vehiculo;

    Double pedidasEconomicas;
}
