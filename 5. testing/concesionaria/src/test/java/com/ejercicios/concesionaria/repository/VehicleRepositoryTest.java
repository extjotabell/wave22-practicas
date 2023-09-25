package com.ejercicios.concesionaria.repository;

import com.ejercicios.concesionaria.entity.Service;
import com.ejercicios.concesionaria.entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryTest {

    VehicleRepository repository;

    @Test
    void Save(){
        //Arrange
        List<Service> service = new ArrayList<>(){{
            new Service( LocalDate.now(),200.0,"algo");
            new Service( LocalDate.now(),300.0,"algo más");
        }};
        Vehicle vehicle = new Vehicle(1,"brand","molde", LocalDate.now(),200,4,20.0,"AR", service, 2);

        //Act
        repository.save(vehicle);

        //Assert
        //Assertions.assertEquals(vehicle, );
        //Assertions.assertFalse(characterDTOList.isEmpty());

    }
}
