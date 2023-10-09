package com.example.ejerciciohql.service;

import com.example.ejerciciohql.dto.request.SiniestroRequestDTO;
import com.example.ejerciciohql.dto.request.VehiculoRequestDTO;
import com.example.ejerciciohql.dto.response.VehiculoResponseDTO;
import com.example.ejerciciohql.entity.Siniestro;
import com.example.ejerciciohql.entity.Vehiculo;
import com.example.ejerciciohql.repository.VehiculoRepository;
import com.example.ejerciciohql.view.VehiculoFindAllPatentesView;
import com.example.ejerciciohql.view.VehiculoFindAllPatentesAndMarcasView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public void addVehiculo(VehiculoRequestDTO vehiculoRequestDTO) {
        vehiculoRepository.save(mapper.map(vehiculoRequestDTO, Vehiculo.class));
    }

    @Override
    public List<VehiculoResponseDTO> findAllVehiculos() {
        return vehiculoRepository.findAll().stream().map(v -> mapper.map(v, VehiculoResponseDTO.class)).toList();
    }

    @Override
    public void addSiniestro(Long idVehiculo, SiniestroRequestDTO siniestroRequestDTO) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(idVehiculo);
        if(vehiculoOpt.isPresent()) {
            Siniestro sin = mapper.map(siniestroRequestDTO, Siniestro.class);
            Vehiculo vehiculo = vehiculoOpt.get();
            vehiculo.getSiniestros().add(sin);
            vehiculoRepository.save(vehiculo);
        }
    }

    @Override
    public List<VehiculoResponseDTO> findAllPatentes() {
        List<VehiculoFindAllPatentesView> vehiculos = vehiculoRepository.findAllPatentes();
        return vehiculos.stream().map(v -> mapper.map(v, VehiculoResponseDTO.class)).toList();
    }

    @Override
    public List<VehiculoResponseDTO> findAllPatentesAndMarcas() {
        //return vehiculoRepository.findAllPatentesAndMarcasOrderByAnio().stream().map(v -> mapper.map(v, VehiculoResponseDTO.class)).toList();
        List<VehiculoFindAllPatentesAndMarcasView> vehiculos = vehiculoRepository.findAllPatentesAndMarcasOrderByAnio();
        return vehiculos.stream().map(v -> mapper.map(v, VehiculoResponseDTO.class)).toList();
    }
}
