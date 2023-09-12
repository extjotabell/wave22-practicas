package com.renzobayarri.calcularcalorias.service;

import com.renzobayarri.calcularcalorias.dto.PlatoDTO;

public interface PlatoService {
    PlatoDTO getInfoPlatoByName(String nombrePlato, double peso);

}
