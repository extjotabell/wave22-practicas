package com.spring.consecionariadeautos.web.mappers;

import com.spring.consecionariadeautos.entities.Car;
import com.spring.consecionariadeautos.web.dto.CarDTO;
import com.spring.consecionariadeautos.web.dto.CarServicesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarServicesMapper {
    Car toEntity(CarServicesDTO carDTO);
    CarServicesDTO toDto(Car car);
}