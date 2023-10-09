package com.meli.practicaaseguradora.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.practicaaseguradora.dto.VehiculoDTO;
import com.meli.practicaaseguradora.model.Vehiculo;
import com.meli.practicaaseguradora.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VehiculoService implements IVehiculoService  {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    VehiculoRepository vehiculoRepository;


    @Override
    public List<VehiculoDTO> findAll() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(v-> mapper.convertValue(v, VehiculoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VehiculoDTO findByID(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isEmpty()){
            throw new RuntimeException("Vehiculo no encontrado");
        }
        return mapper.convertValue(vehiculo.get(), VehiculoDTO.class);
    }

    @Override
    public List<VehiculoDTO> getAllPatentes() {
        return vehiculoRepository.findAll().stream()
                .map(v -> VehiculoDTO.builder()
                        .patente(v.getPatente())
                .build())
                .toList();

    }

    @Override
    public List<VehiculoDTO> getAllPatentesMarcas() {
        return vehiculoRepository.findAllByYear().stream()
                .map(v -> VehiculoDTO.builder()
                        .patente(v.getPatente())
                        .marca(v.getMarca())
                        .build())
                .toList();
    }

    @Override
    public List<VehiculoDTO> getPatenteRuedasAnioActual() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllByCantWheelAndDate();
        return vehiculos.stream()
                .map(v-> mapper.convertValue(v, VehiculoDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoDTO> getPerdidas() {
       return vehiculoRepository.findAllBySinBigger10k().stream()
                .map(v -> VehiculoDTO.builder()
                        .modelo(v.getModelo())
                        .matricula(v.getMatricula())
                        .marca(v.getMarca())
                        .build())
                .toList();
    }


}
