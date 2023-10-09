package com.meli.practicaaseguradora.service;

import com.meli.practicaaseguradora.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoDTO> findAll();
    VehiculoDTO findByID(Long id);
    List<VehiculoDTO> getAllPatentes();
    List<VehiculoDTO> getAllPatentesMarcas();
    List<VehiculoDTO> getPatenteRuedasAnioActual();
    List<VehiculoDTO> getPerdidas();


}
