package com.example.ejerciciopracticogrupal.service;

import com.example.ejerciciopracticogrupal.dto.response.*;
import com.example.ejerciciopracticogrupal.projection.MarcaPatenteModeloView;
import com.example.ejerciciopracticogrupal.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    ObjectMapper objectMapper;

    private final ModelMapper modelMapper;

    public VehiculoServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PatentesDTO getAllPatentes() {
        return new PatentesDTO(vehiculoRepository.findAllPatentes());
    }

    @Override
    public List<?> getAllPatentesYMarcas() {
        return vehiculoRepository.findAllPatentesYMarcas()
                .stream()
                .map(obj -> modelMapper.map(obj, VehiculoDTO.class))
                .toList();
    }

    @Override
    public PatentesDTO getAllVehiculos4RuedasYActuales() {
        return new PatentesDTO(vehiculoRepository.findAllPatentes4RuedasAndActualYear());
    }

    @Override
    public List<?> getAllPatentesYMarcasConPerdidaEconomica() {
        List<MarcaPatenteModeloView> vehiculos = this.vehiculoRepository.findAllPatentesYMarcasConPerdidaEconomica();

        return vehiculos.stream()
                .map(v -> modelMapper.map(v, VehiculoSiniestroDTO.class))
                .toList();

    }

    @Override
    public List<VehiculoSiniestroDTO> getAllPatentesYMarcasConPerdidaEconomicaYTotal() {
        List<MarcaPatenteModeloView> vehiculoConPerdidasTotales = vehiculoRepository.findAllPatentesYMarcasConPerdidaEconomicaYTotal();
        return vehiculoConPerdidasTotales.stream()
                .map(v -> modelMapper.map(v, VehiculoSiniestroDTO.class))
                .toList();
    }
}
