package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.*;
import com.example.empresaseguros.entity.Vehiculo;
import com.example.empresaseguros.repository.VehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    VehiculoRepository repository;

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public Integer create(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = toEntity(vehiculoDTO);
        return repository.save(vehiculo).getId_vehiculo();
    }

    public List<PatenteDTO> getAllLicensePlate() {
        return repository.obtenerTodasLasPatentes();
    }

    @Override
    public List<PatenteMarcaYModeloConPerdidaTotalDTO> obtenerVehiculosConSiniestroMayorA10000YTotalPerdidaEconomica() {
        return null;
    }

    @Override
    public List<PatenteMarcaYModeloDTO> obtenerVehiculosConSiniestroMayorA10000() {
        return repository.obtenerVehiculosConSiniestroMayorA10000();
    }

    @Override
    public List<PatenteDTO> obtenerPatenteDeVehiculosMasde4Ruedas() {
        return repository.patentesMasDe4RuedasDeEsteAño();
    }

    @Override
    public List<MarcaYPatenteDTO> obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion() {
        return repository.obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion();

    }

    private List<VehiculoDTO> toDTOs(List<Vehiculo> vehiculoList) {
        return vehiculoList.stream()
                .map(this::toDto).toList();
    }

    private VehiculoDTO toDto(Vehiculo vehiculo) {
        return mapper.convertValue(vehiculo, VehiculoDTO.class);
    }

    private List<Vehiculo> toEntities(List<VehiculoDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity).toList();
    }

    private Vehiculo toEntity(VehiculoDTO dto) {
        return mapper.convertValue(dto, Vehiculo.class);
    }
}
