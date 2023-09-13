package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.UpdatedVehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable long id, @RequestBody UpdatedVehicleDto vehicleUpdated){
        vehicleService.updateMaxSpeed(id, vehicleUpdated);
        return new ResponseEntity<>("Velocidad del vehículo actualizada exitosamente.", HttpStatus.OK);
    }
}
