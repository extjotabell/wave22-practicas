package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.VehiculoDTO;
import com.example.empresaseguros.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    Integer create(VehiculoDTO vehiculoDTO);

    List<VehiculoDTO> getAll();
}
