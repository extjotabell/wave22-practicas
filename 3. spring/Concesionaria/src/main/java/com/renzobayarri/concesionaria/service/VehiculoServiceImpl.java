package com.renzobayarri.concesionaria.service;

import com.renzobayarri.concesionaria.dto.ServiceDTO;
import com.renzobayarri.concesionaria.dto.VehiculoDTO;
import com.renzobayarri.concesionaria.dto.VehiculoWithoutServices;
import com.renzobayarri.concesionaria.entity.Services;
import com.renzobayarri.concesionaria.entity.Vehiculo;
import com.renzobayarri.concesionaria.exceptions.NotFoundException;
import com.renzobayarri.concesionaria.repository.IVehiculoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private IVehiculoRepository vehiculoRepository;


    @Override
    public List<VehiculoWithoutServices> findAll() {
        return vehiculoRepository.findAll().stream().map(this::toVehiculoWithoutServices).toList();
    }

    @Override
    public VehiculoDTO findById(int id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id);
        if(vehiculo == null){
            throw new NotFoundException();
        }
        return toVehiculoDTO(vehiculo);
    }

    @Override
    public List<VehiculoDTO> findByManufacturingDateBetween(LocalDate since, LocalDate to) {
        return vehiculoRepository.findByManufacturingDateBetween(since, to).stream().map(this::toVehiculoDTO).toList();
    }

    @Override
    public List<VehiculoDTO> findByPriceBetween(double since, double to) {
        return vehiculoRepository.findByPriceBetween(since, to).stream().map(this::toVehiculoDTO).toList();

    }

    @Override
    public VehiculoDTO save(VehiculoDTO vehiculoDTO) {
        return toVehiculoDTO(vehiculoRepository.save(toVehiculo(vehiculoDTO)));
    }

    public Vehiculo toVehiculo(VehiculoDTO vehiculoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        vehiculo.setServices(vehiculoDTO.getServices().stream().map(this::toService).toList());
        return vehiculo;
    }

    public VehiculoDTO toVehiculoDTO(Vehiculo vehiculo){
        ModelMapper modelMapper = new ModelMapper();
        VehiculoDTO vehiculoDTO = modelMapper.map(vehiculo, VehiculoDTO.class);
        vehiculoDTO.setServices(vehiculo.getServices().stream().map(this::toServiceDTO).toList());
        return vehiculoDTO;
    }

    public VehiculoWithoutServices toVehiculoWithoutServices(Vehiculo vehiculo){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehiculo, VehiculoWithoutServices.class);
    }

    public ServiceDTO toServiceDTO(Services services){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(services, ServiceDTO.class);
    }

    public Services toService(ServiceDTO serviceDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(serviceDTO, Services.class);
    }
}
