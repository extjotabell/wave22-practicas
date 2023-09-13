package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelDto;
import com.bootcampW22.EjercicioGlobal.dto.UpdateSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping ("/vehicles")
    public ResponseEntity<?> saveVehicle(@Valid @RequestBody VehicleDto vehicletoSave){
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicletoSave), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color,@PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color,year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String brand,@PathVariable Integer start_year, @PathVariable Integer end_year){
        return new ResponseEntity<>(vehicleService.searchByBrandAndYears(brand,start_year,end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getPromFromBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeed(brand), HttpStatus.OK);
    }

    @PostMapping ("/vehicles/batch")
    public ResponseEntity<?> saveVehicle(@RequestBody List<VehicleDto> vehicletoSave){
        return new ResponseEntity<>(vehicleService.saveVehicles(vehicletoSave), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @Valid @RequestBody UpdateSpeedDto updateSpeedDto){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, updateSpeedDto), HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getByFuel(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByFuel(type), HttpStatus.OK);
    }

    @DeleteMapping ("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> getByTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByTransmission(type), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> update_fuel(@PathVariable Long id,@Valid @RequestBody UpdateFuelDto updateFuelDto){
        return new ResponseEntity<>(vehicleService.updateFuel(id, updateFuelDto),HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageCapacity(brand),HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeigth(@RequestParam Double min, @RequestParam Double max){
        return new ResponseEntity<>(vehicleService.searchVehiclesByWeight(min, max),HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByWidthAndHeigth(@RequestParam String height, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.searchVehiclesByHeigthYWidth(height, width),HttpStatus.OK);
    }
}
