package com.bootcampW22.EjercicioGlobal.Mapping;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Component
public class MapDto {
    public Vehicle toVehicle(VehicleDto vehicleDto){
        Vehicle newVehicle = new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                vehicleDto.getRegistration(),
                vehicleDto.getColor(),
                vehicleDto.getYear(),
                vehicleDto.getMax_speed(),
                vehicleDto.getPassengers(),
                vehicleDto.getFuel_type(),
                vehicleDto.getTransmission(),
                vehicleDto.getHeight(),
                vehicleDto.getWidth(),
                vehicleDto.getWeight()
        );
        return newVehicle;
    }

    public VehicleDto toVehicleDto(Vehicle vehicle){
        VehicleDto newVehicleDto = new VehicleDto(
        vehicle.getId(),
        vehicle.getBrand(),
        vehicle.getModel(),
        vehicle.getRegistration(),
        vehicle.getColor(),
        vehicle.getYear(),
        vehicle.getMax_speed(),
        vehicle.getPassengers(),
        vehicle.getFuel_type(),
        vehicle.getTransmission(),
        vehicle.getHeight(),
        vehicle.getWidth(),
        vehicle.getWeight()
        );
        return newVehicleDto;
    }

}
