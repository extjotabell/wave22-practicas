package com.renzobayarri.concesionaria.service;

import com.renzobayarri.concesionaria.dto.VehiculoDTO;
import com.renzobayarri.concesionaria.dto.VehiculoWithoutServices;

import java.time.LocalDate;
import java.util.List;

public interface VehiculoService {

    List<VehiculoWithoutServices> findAll();

    VehiculoDTO findById(int id);

    List<VehiculoDTO> findByManufacturingDateBetween(LocalDate since, LocalDate to);

    List<VehiculoDTO> findByPriceBetween(double since, double to);

    VehiculoDTO save(VehiculoDTO vehiculoDTO);

}
