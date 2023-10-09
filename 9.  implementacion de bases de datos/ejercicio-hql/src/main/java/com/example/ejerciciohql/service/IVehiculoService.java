package com.example.ejerciciohql.service;

import com.example.ejerciciohql.dto.request.SiniestroRequestDTO;
import com.example.ejerciciohql.dto.request.VehiculoRequestDTO;
import com.example.ejerciciohql.dto.response.VehiculoResponseDTO;

import java.util.List;

public interface IVehiculoService {

    void addVehiculo(VehiculoRequestDTO vehiculoRequestDTO);
    List<VehiculoResponseDTO> findAllVehiculos();
    void addSiniestro(Long idVehiculo, SiniestroRequestDTO siniestroRequestDTO);
    List<VehiculoResponseDTO> findAllPatentes();
    List<VehiculoResponseDTO> findAllPatentesAndMarcas();
}
