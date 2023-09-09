package com.spring.consecionariadeautos.repositories.impl;

import com.spring.consecionariadeautos.entities.Car;
import com.spring.consecionariadeautos.entities.ServiceCar;
import com.spring.consecionariadeautos.repositories.ICarRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class CarRepositoryImpl implements ICarRepository {

    List<Car> carsList;
    public CarRepositoryImpl() {
        ServiceCar s1 = new ServiceCar(LocalDate.of(2020,12,9), 10000, "Cambio de ruedas");
        ServiceCar s2 = new ServiceCar(LocalDate.of(2021, 3, 15), 10000, "Cambio de aceite");
        List<ServiceCar> services1 = Arrays.asList(s1, s2);

        ServiceCar s3 = new ServiceCar(LocalDate.of(2022, 7, 10), 50000, "Inspección anual");
        ServiceCar s4 = new ServiceCar(LocalDate.of(2023, 1, 5), 30000, "Cambio de frenos");
        List<ServiceCar> services2 = Arrays.asList(s3, s4);


        ServiceCar s5 = new ServiceCar(LocalDate.of(2021, 9, 20), 20000, "Alineación y balanceo");
        ServiceCar s6 = new ServiceCar(LocalDate.of(2022, 6, 8), 15000, "Cambio de filtro de aire");
        List<ServiceCar> services3 = Arrays.asList(s5, s6);


        ServiceCar s7 = new ServiceCar(LocalDate.of(2020, 12, 12), 5000, "Cambio de bujías");
        ServiceCar s8 = new ServiceCar(LocalDate.of(2023, 8, 25), 25000, "Rotación de neumáticos");
        List<ServiceCar> services4 = Arrays.asList(s7, s8);


        ServiceCar s9 = new ServiceCar(LocalDate.of(2021, 4, 7), 30000, "Cambio de batería");
        ServiceCar s10 = new ServiceCar(LocalDate.of(2022, 11, 30), 40000, "Inspección de frenos");
        List<ServiceCar> services5 = Arrays.asList(s9, s10);


        Car c1 = new Car(1L, "Chevrolet", "Corsa", LocalDate.of(2009, 8, 19), 2000, 4, 1800000.00, "AR", services1, 1 );
        Car c2 = new Car(2L, "Ford", "Focus", LocalDate.of(2015, 5, 10), 90000, 5, 2500000.00, "AR", services2, 3);
        Car c3 = new Car(3L, "Toyota", "Camry", LocalDate.of(2020, 7, 3), 20000, 4, 3800000.00, "AR", services3, 0);
        Car c4 = new Car(4L, "Volkswagen", "Golf", LocalDate.of(2018, 1, 14), 60000, 5, 2200000.00, "AR", services4, 2);
        Car c5 = new Car(5L, "Renault", "Clio", LocalDate.of(2014, 3, 5), 120000, 3, 1500000.00, "AR", services5, 1);

        carsList = Arrays.asList(c1, c2, c3, c4, c5);
    }
    @Override
    public Car add(Car car) {
        carsList.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return carsList;
    }

    @Override
    public List<Car> findByDate(LocalDate date) {
        List<Car> carListAfterDate = new ArrayList<>();
        carListAfterDate = carsList.stream()
                .filter(car -> car.getManufacturingDate().isAfter(date))
                .toList();
        return carListAfterDate;
    }

    @Override
    public List<Car> findByPrice(Double price, Double secondPrice) {
        List<Car> carListBeetwenPrices = new ArrayList<>();
        carListBeetwenPrices = carsList.stream()
                .filter(car -> car.getPrice() >= price && car.getPrice() <= secondPrice)
                .toList();
        return carListBeetwenPrices;
    }

    @Override
    public Car get(Long id) {
        Car carFound = null;
        for (Car c : carsList) {
            if (Objects.equals(c.getId(), id)) {
                carFound = c;
            }
        }
        return carFound;
    }

}
