package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.VehiculoDTO;
import com.example.empresaseguros.dto.responce.VehiculoPatenteDTO;
import com.example.empresaseguros.entity.Vehiculo;
import com.example.empresaseguros.repository.VehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    VehiculoRepository repository;

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public Integer create(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.convertValue(vehiculoDTO, Vehiculo.class);
        return repository.save(vehiculo).getId_vehiculo();
    }

    public List<VehiculoDTO> getAll(){
        List<Vehiculo> vehiculoList = repository.findAll();

        return vehiculoList.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, VehiculoDTO.class)).toList();
    }

    @Override
    public List<VehiculoPatenteDTO> getAllPatentes() {
        List<String> patentesList = repository.obtenerTodasLasPatentes();

        return patentesList.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo , VehiculoPatenteDTO.class)).toList();
    }

    public List<VehiculoDTO> getVehiculosMas4RuedasDeEsteAño(){
        List<Vehiculo> vehiculos = repository.patentesMasDe4RuedasDeEsteAño();
        List<VehiculoDTO> vehiculosDTO = new ArrayList<>();
        for (Vehiculo v: vehiculos) {
            vehiculosDTO.add(mapper.convertValue(v, VehiculoDTO.class));
        }
        return vehiculosDTO;
    }

}
