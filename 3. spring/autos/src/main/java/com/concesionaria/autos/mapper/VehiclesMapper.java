package com.concesionaria.autos.mapper;

import com.concesionaria.autos.dto.ServiceDTO;
import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Service;
import com.concesionaria.autos.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiclesMapper {
    public Vehicle mapToEntity(VehicleDTO vehicleDto) {
        List<Service> listService = new ArrayList<>();
        System.out.println(vehicleDto.getServices());
        for (ServiceDTO service: vehicleDto.getServices()) {
            listService.add(new Service(service.getDate(), service.getKilometers(), service.getDescription()));
        }

        Vehicle vehicle = new Vehicle(
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                vehicleDto.getManufacturingDate(),
                vehicleDto.getNumberOfKilometers(),
                vehicleDto.getDoors(),
                vehicleDto.getPrice(),
                vehicleDto.getCurrency(),
                listService,
                vehicleDto.getCountOfOwners()
        );

        return vehicle;
    }

    public VehicleDTO mapToDto(Vehicle vehicle) {
        List<ServiceDTO> listServiceDto = new ArrayList<>();
        for (Service service: vehicle.getServices()) {
            listServiceDto.add(new ServiceDTO(service.getDate(), service.getKilometers(), service.getDescription()));
        }
        
        VehicleDTO vehicleDto = new VehicleDTO(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners(),
                listServiceDto

        );
        return vehicleDto;
    }
}
