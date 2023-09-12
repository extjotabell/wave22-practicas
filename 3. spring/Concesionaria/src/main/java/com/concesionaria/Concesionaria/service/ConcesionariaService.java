package com.concesionaria.Concesionaria.service;

import com.concesionaria.Concesionaria.dtos.CarDTO;
import com.concesionaria.Concesionaria.dtos.CarNoServicesDTO;
import com.concesionaria.Concesionaria.entity.Car;
import com.concesionaria.Concesionaria.exceptions.CarsNotFound;
import com.concesionaria.Concesionaria.repository.ConcesionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConcesionariaService implements IConcesionariaService{

    private int id;

    public ConcesionariaService() {
        this.id = 0;
    }

    @Autowired
    ConcesionariaRepository repo;

    @Override
    public void saveCar(CarDTO car) {
        Car entityCar = new Car(id,car.getBrand(),car.getModel(),car.getManufacturingDate(),car.getNumberOfKilometers(),car.getDoors(),car.getPrice(),car.getCurrency(),car.getServices(),car.getCountOfOwners());
        repo.saveCar(entityCar);
        id++;
    }

    @Override
    public List<CarNoServicesDTO> getAll() {
        List<CarNoServicesDTO> cars = repo.getAll().stream().map(c-> new CarNoServicesDTO(c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getCountOfOwners())).toList();
        return cars;
    }

    @Override
    public List<CarDTO> findByDate(LocalDate since, LocalDate to) {
        List<CarDTO> carsByDate = repo.findByDate(since,to).stream().map(c-> new CarDTO(c.getId(),c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getServices(),c.getCountOfOwners())).toList();
        if(carsByDate.isEmpty()){
            throw new CarsNotFound("No se encontraron autos con esta fecha");
        }
        return carsByDate;
    }

    @Override
    public List<CarDTO> findByPrice(String since, String to) {
        List<CarDTO> carByPrice = repo.findByPrice(since, to).stream().map(c-> new CarDTO(c.getId(),c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getServices(),c.getCountOfOwners())).toList();
        if(carByPrice.isEmpty()){
            throw new CarsNotFound("No se encontraron autos con ese rango de precio");
        }
        return carByPrice;
    }

    @Override
    public CarDTO findById(int id) {
        Car carbyid = repo.findById(id);
        if(carbyid == null){
            throw new CarsNotFound("No existe auto con ese id");
        }
        CarDTO car = new CarDTO(carbyid.getId(), carbyid.getBrand(), carbyid.getModel(), carbyid.getManufacturingDate(),carbyid.getNumberOfKilometers(), carbyid.getDoors(), carbyid.getPrice(), carbyid.getCurrency(), carbyid.getServices(),carbyid.getCountOfOwners());
        return car;
    }
}
