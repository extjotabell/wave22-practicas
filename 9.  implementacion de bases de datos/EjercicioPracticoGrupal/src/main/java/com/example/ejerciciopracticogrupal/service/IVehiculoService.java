package com.example.ejerciciopracticogrupal.service;

import com.example.ejerciciopracticogrupal.dto.response.PatentesDTO;
import com.example.ejerciciopracticogrupal.dto.response.PerdidasPorVehiculoDTO;
import com.example.ejerciciopracticogrupal.dto.response.VehiculoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehiculoService {
    PatentesDTO getAllPatentes();

    List<VehiculoDTO> getAllPatentesYMarcas();

    PatentesDTO getAllVehiculos4RuedasYActuales();

    List<VehiculoDTO> getAllPatentesYMarcasConPerdidaEconomica();

    List<PerdidasPorVehiculoDTO> getAllPatentesYMarcasConPerdidaEconomicaYTotal();
}
