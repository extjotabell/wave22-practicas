package com.spring.consecionariadeautos.web.mappers;

import com.spring.consecionariadeautos.entities.Car;
import com.spring.consecionariadeautos.web.dto.CarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car toEntity(CarDTO carDTO);
    CarDTO toDto(Car car);
}
