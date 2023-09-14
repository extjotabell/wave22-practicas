package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.MapperDto.MapDtos;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    MapDtos mapDtos;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, MapDtos mapDtos){
        this.vehicleRepository = vehicleRepository;
        this.mapDtos = mapDtos;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findBetweenYears(String brand, int start_year, int end_year) {

        if(!vehicleRepository.findValidBrand(brand)){
            throw new NotFoundException("No es una marca valida");
        }

        List<VehicleDto> listResponse = vehicleRepository.findAll().stream().map(mapDtos::toDto).filter(x->x.getYear()>=start_year&&x.getYear()<=end_year && x.getBrand().equals(brand)).toList();

        if(listResponse.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos para estos criterios");
        }
        return listResponse;
    }




}
