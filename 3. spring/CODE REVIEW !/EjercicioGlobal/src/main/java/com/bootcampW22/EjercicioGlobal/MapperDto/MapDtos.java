package com.bootcampW22.EjercicioGlobal.MapperDto;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class MapDtos {

    public VehicleDto toDto(Vehicle vehicle){
        if(vehicle!=null){
            VehicleDto vehicleDto = new VehicleDto(
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

            return vehicleDto;
        }
        return null;
    }

}
