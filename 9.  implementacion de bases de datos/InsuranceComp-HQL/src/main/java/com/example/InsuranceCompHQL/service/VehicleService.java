package com.example.InsuranceCompHQL.service;

import com.example.InsuranceCompHQL.dto.PlateBrandDto;
import com.example.InsuranceCompHQL.dto.PlateDto;
import com.example.InsuranceCompHQL.entity.PlateBrand;
import com.example.InsuranceCompHQL.entity.Vehicle;
import com.example.InsuranceCompHQL.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;
    @Override
    public List<PlateDto> getAllPlates() {
        List<String> plates = vehicleRepository.getAllPlates();
        return  plates.stream().map(PlateDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PlateBrandDto> getPlateAndBrandByYear(int year) {
        List<PlateBrand> list = vehicleRepository.getPlateAndBrandByYear(year);
        return null;
    }

    public List<Vehicle> getAll(){
        return vehicleRepository.findAll();
    }
}
