package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public void updateFuelType(Long id, String fuelType) {

        if (!vehicleRepository.existsVehicle(id)){
            throw new NotFoundException("No se encontro el vehiculo");
        }

        if (fuelType != "gasoline" | fuelType != "diesel" | fuelType != "biodiesel" | fuelType != "gas") {
            throw new BadRequestException("Tipo de combustible mal formado o no admitido");
        }

        Optional<Vehicle> vehicle = vehicleRepository.getVehicleById(id);

        if (vehicle.isPresent()){

            Vehicle vehicleUpdate = vehicle.get();

            vehicleUpdate.setFuel_type(fuelType);

            int index = -1;

            for (var car: searchAllVehicles()) {
                if (Objects.equals(car.getId(), id)){
                    index = searchAllVehicles().indexOf(car);
                }
            }

            vehicleRepository.updateVehicle(index, vehicleUpdate);
        }

    }
}
