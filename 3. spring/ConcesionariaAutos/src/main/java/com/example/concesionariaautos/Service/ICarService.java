package com.example.concesionariaautos.Service;

import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;

import java.util.List;

public interface ICarService {

    void CreateCar(CarServiceDto carDto);
    List<CarDto> AllCAr();
    List<CarServiceDto> GetCarDate(String since );
    List<CarServiceDto> GetCarPrice(int since , int to);
    CarServiceDto GetById(int id);

}
