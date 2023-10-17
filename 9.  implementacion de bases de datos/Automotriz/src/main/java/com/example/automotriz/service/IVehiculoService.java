package com.example.automotriz.service;

import com.example.automotriz.dto.VehiculoDTO;
import com.example.automotriz.model.Vehiculo;
import com.example.automotriz.model.VehiculoData;
import com.example.automotriz.model.VehiculoSiniestro;

import java.util.List;

public interface IVehiculoService {
    VehiculoDTO buscarPorId(Long id);
    List<VehiculoDTO> buscarTodos();
    String crearVehiculo(VehiculoDTO dto);
    List<String> listarPatentes();
    List<VehiculoData> listarPatentesYMarcasOrderbyAnioFabricacion();
    List<String> listarPatenteMasCuatroRuedasYFabricadosAnioActual();
    List<VehiculoData> listarVehiculosSiniestroMayorDiezMilPesos();
    List<VehiculoSiniestro> listarVehiculosSiniestroMayorDiezMilPesosPerdidaTotal();
}
