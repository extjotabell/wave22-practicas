package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.Mapping.MapDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ExistVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    IVehicleRepository vehicleRepository;
    MapDto mapDto;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, MapDto mapDto){
        this.vehicleRepository = vehicleRepository;
        this.mapDto = mapDto;
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
    public void add(VehicleDto vehicleDto) {
        if(vehicleDto !=null && vehicleDto.getId()!=null && vehicleDto.getModel()!=null && vehicleDto.getBrand() !=null){
            Vehicle vehicle = mapDto.toVehicle(vehicleDto);
            vehicleRepository.add(vehicle);
        } else throw new BadRequestException("El objeto ni sus propiedades no pueden venir nulas !");
    }

    @Override
    public VehicleDto findById(Long id) {
        if(vehicleRepository.findById(id) == null){
            return null;
        } else {
            VehicleDto newVehicleDto = mapDto.toVehicleDto(vehicleRepository.findById(id));
            return newVehicleDto;
        }
    }

    @Override
    public List<VehicleDto> findBetweenYears(String brand, int start_year, int end_year) {
        return vehicleRepository.findAll().stream().map(mapDto::toVehicleDto).filter(x->x.getBrand().equals(brand)
                && x.getYear() >= start_year && x.getYear() <= end_year).toList();
    }

    @Override
    public double avergareSpeed(String brand) {
        return vehicleRepository.findAll().stream().filter(x->x.getBrand().equals(brand)).mapToDouble
                (obj -> Double.parseDouble(obj.getMax_speed())).average().orElse(0.0);
    }

    @Override
    public void addList(List<VehicleDto> list) {
        try{
            List<Vehicle> listToAdd = new ArrayList<>();
            listToAdd = list.stream().map(mapDto::toVehicle).toList();

            for(int i =0; i < listToAdd.size(); i++){

                if (vehicleRepository.findById(listToAdd.get(i).getId())!=null){
                    throw new ExistVehicleException("En la lista se encontro que el id: " + listToAdd.get(i).getId() + " ya se encuentra siendo utilizado por otro vehiculo");
                } else {
                    vehicleRepository.add(listToAdd.get(i));
                }
            }

        } catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }


    }


}
