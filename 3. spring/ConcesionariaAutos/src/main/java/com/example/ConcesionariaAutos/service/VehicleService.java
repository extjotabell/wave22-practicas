package com.example.ConcesionariaAutos.service;

import com.example.ConcesionariaAutos.dto.PostVehicleDTO;
import com.example.ConcesionariaAutos.dto.VehicleDTO;
import com.example.ConcesionariaAutos.entity.Vehicle;
import com.example.ConcesionariaAutos.exception.NotFoundException;
import com.example.ConcesionariaAutos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    private final IVehicleRepository repo;

    public VehicleService(IVehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Integer addVehicle(PostVehicleDTO vehicleDto){
        Vehicle vehicle = new ModelMapper().map(vehicleDto, Vehicle.class);
        return repo.addVehicle(vehicle);
    }

    @Override
    public VehicleDTO getVehicleById(Integer id) {
        Vehicle vehicle = repo.getVehicleById(id);
        if(vehicle == null){
            throw new NotFoundException("Vehiculo no encontrado con id: " + id);
        }
        return new ModelMapper().map(vehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        List<Vehicle> vehicles = this.repo.getVehicles();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos");
        }

        return vehicles.stream()
                .map(v-> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = this.repo.getVehiclesByDate(since, to);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos desde la fecha "
                    + since
                    + "hasta la fecha "
                    + to);
        }

        return vehicles.stream()
                .map(v -> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(double from, double to) {
        List<Vehicle> vehicles = this.repo.getVehiclesByPrice(from, to);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con precio desde $"
                    + from
                    + "hasta $"
                    + to);
        }

        return vehicles.stream()
                .map(v -> new ModelMapper().map(v, VehicleDTO.class))
                .collect(Collectors.toList());
    }
}
