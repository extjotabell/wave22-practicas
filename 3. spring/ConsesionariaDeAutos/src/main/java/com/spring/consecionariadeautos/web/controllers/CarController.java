package com.spring.consecionariadeautos.web.controllers;

import com.spring.consecionariadeautos.entities.Car;
import com.spring.consecionariadeautos.repositories.ICarRepository;
import com.spring.consecionariadeautos.services.ICarService;
import com.spring.consecionariadeautos.web.dto.CarDTO;
import com.spring.consecionariadeautos.web.dto.CarServicesDTO;
import com.spring.consecionariadeautos.web.mappers.CarMapper;
import com.spring.consecionariadeautos.web.mappers.CarServicesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class CarController {

    private final ICarService iCarService;
    private final CarMapper carMapper;
    private final CarServicesMapper carServicesMapper;

    @PostMapping
    ResponseEntity<CarServicesDTO> addCar(@RequestBody CarServicesDTO carDTO) {
        Car car = carServicesMapper.toEntity(carDTO);
        iCarService.addCar(car);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping
    ResponseEntity<List<CarDTO>> getAllCars() {
        List<Car> cars = iCarService.findAllCars();
        List<CarDTO> carDTOS = new ArrayList<>();

        carDTOS = cars.stream()
                .map(carMapper::toDto).toList();

        return ResponseEntity.ok(carDTOS);
    }

    @GetMapping("/dates")
    ResponseEntity<List<CarDTO>> getCarsByDate(@RequestParam(name = "since") LocalDate since) {
        List<Car> cars = iCarService.findCarsByDate(since);
        List<CarDTO> carDTOS = new ArrayList<>();
        carDTOS = cars.stream()
                .map(carMapper::toDto).toList();
        return ResponseEntity.ok(carDTOS);
    }

    @GetMapping("/prices")
    ResponseEntity<List<CarDTO>> getCarsByPrices(@RequestParam(name = "since") Double since, @RequestParam(name = "to") Double to) {
        List<Car> cars = iCarService.findCarsByPrice(since, to);
        List<CarDTO> carDTOS = new ArrayList<>();
        carDTOS = cars.stream()
                .map(carMapper::toDto).toList();
        return ResponseEntity.ok(carDTOS);
    }

    @GetMapping("/{id}")
    ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        CarDTO carDTO = carMapper.toDto(iCarService.getCar(id));
        return ResponseEntity.ok(carDTO);
    }

}
