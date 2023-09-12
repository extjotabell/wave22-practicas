package com.ejercicios.concesionaria.service;

import com.ejercicios.concesionaria.dto.RequestVehicleDTO;
import com.ejercicios.concesionaria.dto.ResponseVehicleDTO;
import com.ejercicios.concesionaria.entity.Vehicle;
import com.ejercicios.concesionaria.repository.IRepository;
import com.ejercicios.concesionaria.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService implements IService <ResponseVehicleDTO, RequestVehicleDTO, Integer> {

    @Autowired
    VehicleRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void save(RequestVehicleDTO obj) {
        Vehicle vehicle = mapper.convertValue(obj, Vehicle.class);
        repository.save(vehicle);
    }

    @Override
    public List<ResponseVehicleDTO> getAll() {

        return repository.getAll()
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle,ResponseVehicleDTO.class))
                .toList();
    }

    @Override
    public ResponseVehicleDTO getById(Integer id) {
        return mapper.convertValue(repository.getById(id), ResponseVehicleDTO.class);
    }

    @Override
    public List<ResponseVehicleDTO> getByDate(LocalDate since, LocalDate to) {

        return repository.getByDate(since, to).stream()
                .map(vehicle -> mapper.convertValue(vehicle, ResponseVehicleDTO.class))
                .toList();
    }

    @Override
    public List<ResponseVehicleDTO> getByPrice(Double since, Double to) {
        return repository.getByPrice(since, to).stream()
                .map(vehicle -> mapper.convertValue(vehicle, ResponseVehicleDTO.class))
                .toList();
    }
}
