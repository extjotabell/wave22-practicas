package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.RangeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehiclesDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;

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

    // ejercicios
    @PostMapping("/vehicles")
    public ResponseEntity<String> addVehicle(@Validated @RequestBody VehicleDto vehicleDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Datos del vehículo con mal formato o incompletos: ");
            bindingResult.getFieldErrors().forEach(error ->
                    errorMessage.append(error.getDefaultMessage()).append("; ")
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
        }

        if(vehicleDto.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id no puede ser nulo");
        }

        Boolean flag = vehicleService.addVehicle(vehicleDto);
        if (flag){
            return ResponseEntity.status(HttpStatus.CREATED).body("Vehiculo creado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El id ya se encuentra en la base de datos");
        }
    }

    // encontrar vehiculo
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findVehicle(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.vehicleService.findVehicle(id));
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findbydimensions(@RequestParam Double min_width, Double max_width, Double min_height, Double max_height){

        RangeDto rangeDto = new RangeDto();
        rangeDto.setMin_width(min_width);
        rangeDto.setMax_width(max_width);
        rangeDto.setMin_height(min_height);
        rangeDto.setMax_height(max_height);

        VehiclesDto vehiclesDto = this.vehicleService.findByRange(rangeDto);

        return ResponseEntity.status(HttpStatus.FOUND).body(vehiclesDto);
    }
}
