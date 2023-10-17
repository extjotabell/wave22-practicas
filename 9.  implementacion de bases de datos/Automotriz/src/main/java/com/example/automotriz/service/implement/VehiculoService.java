package com.example.automotriz.service.implement;

import com.example.automotriz.dto.VehiculoDTO;
import com.example.automotriz.model.Vehiculo;
import com.example.automotriz.model.VehiculoData;
import com.example.automotriz.model.VehiculoSiniestro;
import com.example.automotriz.repository.IVehiculoRepository;
import com.example.automotriz.service.IVehiculoService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDTO buscarPorId(Long id) {
        return toDTO(vehiculoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El vehiculo con id " + id + " no fue encontrado")));
    }

    @Override
    public List<VehiculoDTO> buscarTodos() {
        return vehiculoRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public String crearVehiculo(VehiculoDTO dto) {
        vehiculoRepository.save(toEntity(dto));
        return "Vehiculo creado con ID: " + dto.getId();
    }

    @Override
    public List<String> listarPatentes() {
        return vehiculoRepository.getAllPatentes();
    }

    @Override
    public List<VehiculoData> listarPatentesYMarcasOrderbyAnioFabricacion() {
        return vehiculoRepository.getPatenteYMarca();
    }

    @Override
    public List<String> listarPatenteMasCuatroRuedasYFabricadosAnioActual() {
        return vehiculoRepository.getPatenteWithConditions();
    }

    @Override
    public List<VehiculoData> listarVehiculosSiniestroMayorDiezMilPesos() {
        return vehiculoRepository.getDetailsForVehiculoWithSiniestroMayorA10000();
    }

    @Override
    public List<VehiculoSiniestro> listarVehiculosSiniestroMayorDiezMilPesosPerdidaTotal() {
        return vehiculoRepository.getTotalForVehiculoWithSiniestroMayorA10000();
    }

    private VehiculoDTO toDTO(Vehiculo vehiculo){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(vehiculo, VehiculoDTO.class);
    }

    private Vehiculo toEntity(VehiculoDTO vehiculoDTO){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(vehiculoDTO, Vehiculo.class);
    }
}
