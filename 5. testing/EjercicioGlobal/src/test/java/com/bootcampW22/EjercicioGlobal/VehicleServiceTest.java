package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    VehicleRepositoryImpl repository;

    @InjectMocks
    VehicleServiceImpl service;

    @Test
    void searchAllVehiclesEmptyListTest(){
        //ARRANGE
        List<Vehicle> repoReturn = new ArrayList<>();

        when(repository.findAll()).thenReturn(repoReturn);
        //ACT
        assertThrows(NotFoundException.class,()->service.searchAllVehicles());

    }
    //{"id":1,"brand":"Pontiac","model":"Fiero","registration":"6603","year":1986,"color":"Mauv","max_speed":85,"fuel_type":"gasoline","transmission":"semi-automatic","passengers":2,"height":105.43,"width":280.28,"weight":288.8}
    @Test
    void searchAllVehiclesOKTest(){
        //ARRANGE
        List<Vehicle> repoReturn = new ArrayList<>();
        repoReturn.add(new Vehicle(1L,"Pontiac","Fiero","6603","Mauv",1986,"85",2,"gasoline","semi-automatic",105.43,280.28,288.8));

        List<VehicleDto> expected = new ArrayList<>();
        expected.add(new VehicleDto(1L,"Pontiac","Fiero","6603","Mauv",1986,"85",2,"gasoline","semi-automatic",105.43,280.28,288.8));

        when(repository.findAll()).thenReturn(repoReturn);
        //ACT
        List<VehicleDto> actual = service.searchAllVehicles();

        //ASSERT
        verify(repository,atLeast(1)).findAll();
        assertEquals(expected,actual);

    }
}
