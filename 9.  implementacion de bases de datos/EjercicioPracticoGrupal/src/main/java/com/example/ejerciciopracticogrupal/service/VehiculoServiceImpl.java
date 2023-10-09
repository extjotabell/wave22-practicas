package com.example.ejerciciopracticogrupal.service;

import com.example.ejerciciopracticogrupal.dto.response.PatentesDTO;
import com.example.ejerciciopracticogrupal.dto.response.PerdidasPorVehiculoDTO;
import com.example.ejerciciopracticogrupal.dto.response.VehiculoDTO;
import com.example.ejerciciopracticogrupal.model.Vehiculo;
import com.example.ejerciciopracticogrupal.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public PatentesDTO getAllPatentes() {
        return new PatentesDTO(vehiculoRepository.findAllPatentes());
    }

    @Override
    public List<VehiculoDTO> getAllPatentesYMarcas() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllPatentesYMarcas();
        return vehiculos.stream()
                .map(v -> objectMapper.convertValue(v, VehiculoDTO.class))
                .toList();
    }

    @Override
    public PatentesDTO getAllVehiculos4RuedasYActuales() {
        return new PatentesDTO(vehiculoRepository.findAllPatentes4RuedasAndActualYear());
    }

    @Override
    public List<VehiculoDTO> getAllPatentesYMarcasConPerdidaEconomica() {
        List<Vehiculo> vehiculos = this.vehiculoRepository.findAllPatentesYMarcasConPerdidaEconomica();
        return vehiculos.stream()
                .map(v -> objectMapper.convertValue(v, VehiculoDTO.class))
                .toList();
    }

    @Override
    public List<PerdidasPorVehiculoDTO> getAllPatentesYMarcasConPerdidaEconomicaYTotal() {
        List<Pair<Vehiculo,Double>> vehiculoConPerdidasTotales = vehiculoRepository.findAllPatentesYMarcasConPerdidaEconomicaYTotal();
        return vehiculoConPerdidasTotales.stream()
                .map(v -> new PerdidasPorVehiculoDTO(objectMapper.convertValue(v.getFirst(), VehiculoDTO.class),v.getSecond()))
                .toList();
    }
}
