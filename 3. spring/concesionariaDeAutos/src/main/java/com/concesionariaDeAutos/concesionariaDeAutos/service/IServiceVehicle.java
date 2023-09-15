package com.concesionariaDeAutos.concesionariaDeAutos.service;

import com.concesionariaDeAutos.concesionariaDeAutos.dto.VehicleDto;
import com.concesionariaDeAutos.concesionariaDeAutos.dto.VehicleWoServicesDto;

import java.util.List;

public interface IServiceVehicle {
    void addVehicle(VehicleDto vehicleDto);
    List<VehicleWoServicesDto> getAllVehicles();
    List<VehicleDto> getVehiclesPerDate(String since, String to);
    List<VehicleDto> getVehiclesPerPrice(double since, double to);
    VehicleDto getVehiclePerId(int id);
}
