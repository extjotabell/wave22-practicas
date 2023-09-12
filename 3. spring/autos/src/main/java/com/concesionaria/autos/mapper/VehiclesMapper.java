package com.concesionaria.autos.mapper;

import com.concesionaria.autos.dto.ServiceDTO;
import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Service;
import com.concesionaria.autos.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehiclesMapper {
    public Vehicle mapToEntity(VehicleDTO vehicleDto) {
        List<Service> listService = new ArrayList<>();
        for (ServiceDTO service: vehicleDto.getServices()) {
            listService.add(new Service(service.getDate(), service.getKilometers(), service.getDescriptions()));
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
                listServiceDto,
                vehicle.getCountOfOwners()
        );
        return vehicleDto;
    }
}
