package com.example.InsuranceCompHQL.controller;

import com.example.InsuranceCompHQL.dto.PlateBrandDto;
import com.example.InsuranceCompHQL.dto.PlateDto;
import com.example.InsuranceCompHQL.entity.Vehicle;
import com.example.InsuranceCompHQL.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAll(){
        return vehicleService.getAll();
    }
    @GetMapping("/plates")
    public ResponseEntity<List<PlateDto>> getAllPlates(){
        return new ResponseEntity<>(vehicleService.getAllPlates(), HttpStatus.OK);
    }

    @GetMapping("/plate-brand")
    public ResponseEntity<List<PlateBrandDto>> getPlateAndBrandByYear(){
        return new ResponseEntity<>(vehicleService.getPlateAndBrandByYear(1970), HttpStatus.OK);
    }
}
