package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.UpdatedVehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
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
    public void updateMaxSpeed(long id, UpdatedVehicleDto updatedVehicleDto) {
        if(searchAllVehicles().stream().anyMatch(v-> v.getId() == id)){
            if((Integer.parseInt(updatedVehicleDto.getMax_speed()) < 1)){
                throw new BadRequest("Velocidad fuera de rango");
            }
            Vehicle vehicle = new Vehicle();
            vehicle.setId(id);
            vehicle.setBrand(updatedVehicleDto.getBrand());
            vehicle.setModel(updatedVehicleDto.getModel());
            vehicle.setRegistration(updatedVehicleDto.getRegistration());
            vehicle.setColor(updatedVehicleDto.getColor());
            vehicle.setYear(updatedVehicleDto.getYear());
            vehicle.setMax_speed(updatedVehicleDto.getMax_speed());
            vehicle.setPassengers(updatedVehicleDto.getPassengers());
            vehicle.setFuel_type(updatedVehicleDto.getFuel_type());
            vehicle.setTransmission(updatedVehicleDto.getTransmission());
            vehicle.setHeight(updatedVehicleDto.getHeight());
            vehicle.setWidth(updatedVehicleDto.getWidth());
            vehicle.setWeight(updatedVehicleDto.getWeight());

            vehicleRepository.updateMaxSpeed(vehicle);

        }else{
            throw new NotFoundException("No se encontró el vehiculo.");

        }
    }
}
