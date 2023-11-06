package com.example.ejerciciopracticogrupal.service;

import com.example.ejerciciopracticogrupal.dto.response.PatentesDTO;
import com.example.ejerciciopracticogrupal.dto.response.VehiculoSiniestroDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehiculoService {
    PatentesDTO getAllPatentes();

    List<?> getAllPatentesYMarcas();

    PatentesDTO getAllVehiculos4RuedasYActuales();

    List<?> getAllPatentesYMarcasConPerdidaEconomica();

    List<VehiculoSiniestroDTO> getAllPatentesYMarcasConPerdidaEconomicaYTotal();
}
