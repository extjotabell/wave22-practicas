package com.example.InsuranceCompHQL.service;

import com.example.InsuranceCompHQL.dto.PlateBrandDto;
import com.example.InsuranceCompHQL.dto.PlateDto;
import com.example.InsuranceCompHQL.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<PlateDto> getAllPlates();
    List<PlateBrandDto> getPlateAndBrandByYear(int year);
    List<Vehicle> getAll();
}
