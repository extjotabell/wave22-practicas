package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;

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

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByHeightAndWidth(@RequestParam String height, @RequestParam String width) throws BadRequestException {
        Pattern pattern = Pattern.compile("^\\d+\\-\\d+$");
        //TODO: refactorizar pattern para que soporte decimales, por el momento solo soporta enteros
        if(!pattern.matcher(height).matches() || !pattern.matcher(width).matches())
            throw new BadRequestException("Formato de números incorrecto");
        String[] heightValues = height.split("-");
        String[] widthValues = width.split("-");
        return new ResponseEntity<>(vehicleService.findVehiclesByHeightAndWidth(Double.parseDouble(heightValues[0]), Double.parseDouble(heightValues[1]), Double.parseDouble(widthValues[0]), Double.parseDouble(widthValues[1])), HttpStatus.OK);
    }
}
