package com.renzobayarri.calcularcalorias.service;

import com.renzobayarri.calcularcalorias.dto.PlatoDTO;

import java.util.List;

public interface PlatoService {
    PlatoDTO getInfoPlatoByName(String nombrePlato, double peso);

    List<PlatoDTO> getInfoPlatos();

}
