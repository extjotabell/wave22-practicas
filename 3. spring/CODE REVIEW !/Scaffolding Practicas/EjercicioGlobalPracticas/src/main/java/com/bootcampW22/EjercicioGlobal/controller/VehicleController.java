package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVechicles(@RequestBody VehicleDto vehicleDto){
        try{
            if(vehicleDto==null || vehicleDto.getId() == null || vehicleDto.getBrand()==null || vehicleDto.getModel()==null){
                throw new Exception("El vehiculo ni sus atributos pueden venir vacios");
            }

            if(vehicleService.findById(vehicleDto.getId())!=null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El vehiculo con id "+ vehicleDto.getId() + " ya se encuentra en la base de datos");
            }

            vehicleService.add(vehicleDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("El vehiculo ha sido creado con exito!");
        } catch(Exception e){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    /*
    double promedio = numeros.stream()
            .mapToInt(Integer::intValue) // Convierte Integer a int
            .average()
            .orElse(0.0);
    */
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> listBetween(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year){
        try{
            List<VehicleDto> listResponse = vehicleService.findBetweenYears(brand, start_year.intValue(), end_year.intValue());

            if(!listResponse.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(listResponse);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay coincidencias");
            }

        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> findAverageSpeed(@PathVariable String brand){

        try{
            double averageSpeed = vehicleService.avergareSpeed(brand);
            if(averageSpeed!= 0.0){
                return ResponseEntity.status(HttpStatus.OK).body(averageSpeed);
            } else throw new NotFoundException("No se pudo calcular el promedio con la marca brindada");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/vehicles/list")
    public ResponseEntity<?> addListVehicles(@RequestBody List<VehicleDto> listDto){
        try{
            if(listDto.isEmpty()){
                throw new BadRequestException("la lista no puede estar vacia");
            } else {
                vehicleService.addList(listDto);
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
