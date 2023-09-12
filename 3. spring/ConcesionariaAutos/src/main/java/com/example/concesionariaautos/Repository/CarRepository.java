package com.example.concesionariaautos.Repository;

import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository implements ICarRepository {
    private List<Car> carList = new ArrayList<>();

    @Override
    public void CreateCar(CarServiceDto carDto) {
        int id= this.carList.size() +1;
        Car car = new Car(id,carDto.getBrand(), carDto.getModel(), carDto.getManufacturingDate(),carDto.getNumerOfKilometes(),carDto.getPrince(), carDto.getServiceList());
        this.carList.add(car);
    }
;
    @Override
    public List<Car> AllCar() {
        return this.carList;
    }

    @Override
    public List<Car> GetCarDate(String since) {
       return this.carList.stream().filter(x-> x.getManufacturingDate().equals(since))
                                   .collect(Collectors.toList());
    }

    @Override
    public List<Car> GetCarPrice(int since, int to) {
        return this.carList.stream().filter(x-> x.getPrice() >= since && x.getPrice() <= to )
                .collect(Collectors.toList());
    }

    @Override
    public Car GetById(int id) {
        return this.carList.stream().filter(x-> x.getId() == id ).findFirst().get();
    }


}
