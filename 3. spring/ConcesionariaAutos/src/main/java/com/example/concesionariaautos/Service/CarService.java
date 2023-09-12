package com.example.concesionariaautos.Service;

import com.example.concesionariaautos.Repository.ICarRepository;
import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    @Autowired
    ICarRepository _repo;
    @Override
    public void CreateCar(CarServiceDto carDto) {
        _repo.CreateCar(carDto);
    }

    @Override
    public List<CarDto> AllCAr() {
        List<CarDto> carDtoList = new ArrayList<>();
        List<Car> carList = _repo.AllUsedCar();
        carDtoList = carList.stream().map(x->new CarDto(
                x.getBrand(),
                x.getModel(),
                x.getManufacturingDate(),
                x.getNumberOfKilometes(),
                x.getDoors(),
                x.getPrice(),
                x.getCurrency(),
                x.getCountOfOwners())
        ).collect(Collectors.toList());
        return carDtoList;
    }

    @Override
    public List<CarServiceDto> GetCarDate(int since,int to) {
        List<Car> carList = _repo.GetCarDate(since,to);
        return CartoDto(carList);
    }

    @Override
    public List<CarServiceDto> GetCarPrice(int since, int to) {
        List<Car> carList = _repo.GetCarPrice(since,to);
        return  CartoDto(carList);
    }

    @Override
    public  CarServiceDto GetById(int id) {
        List<Car> carList = new ArrayList<>();
        carList.add(_repo.GetById(id));
        return  CartoDto(carList).get(0);
    }

    private List<CarServiceDto> CartoDto(List<Car> carList) {
        return  carList.stream().map(x->new CarServiceDto(x.getBrand(),x.getModel(),x.getManufacturingDate(),x.getNumberOfKilometes(),
                                                          x.getDoors(),x.getPrice(),x.getCurrency(),x.getServiceList(),x.getCountOfOwners())).collect(Collectors.toList());
    }
}
