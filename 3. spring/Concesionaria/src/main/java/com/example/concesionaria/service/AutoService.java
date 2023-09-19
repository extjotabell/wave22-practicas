package com.example.concesionaria.service;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.dto.AutoServiceDTO;
import com.example.concesionaria.entity.Auto;
import com.example.concesionaria.mapper.AutoMapper;
import com.example.concesionaria.repository.IAutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AutoService implements IAutoService {

    private final IAutoRepository carRepository;
    private final AutoMapper autoMapper;

    @Override
    public AutoServiceDTO createCar(AutoServiceDTO autoServiceDTO) {
        Auto auto = autoMapper.toEntity(autoServiceDTO);
        carRepository.createAuto(auto);
        return autoServiceDTO;
    }

    @Override
    public List<AutoDTO> getCars() {
        return carRepository.obtenerAutos()
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    @Override
    public List<AutoDTO> getCarsByDateSince(String date, String toDate) {
        LocalDate aDate = LocalDate.parse(date);
        LocalDate aToDate = LocalDate.parse(toDate);

        return carRepository.obtenerAutosPorFechaDesde(aDate, aToDate)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    @Override
    public List<AutoDTO> getCarsByPrice(double price, double to) {
        return carRepository.obtenerAutosPorPrecioDesde(price, to)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    @Override
    public AutoServiceDTO getCarById(int id) {
        return autoMapper.toDTOService(carRepository.obtenerAutoPorId(id));
    }
}