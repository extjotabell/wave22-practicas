package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.PatenteDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaModeloDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaModeloSumatoriaDTO;
import com.movies.demoHQL.model.Vehiculo;
import com.movies.demoHQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehiculoRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PatenteDTO> allPatentes(){
        Set<String> patentes = repository.obtenerTodasLasPatentes();
        List<PatenteDTO> patenteDTOS = new ArrayList<>();
        for (String patente : patentes) patenteDTOS.add(new PatenteDTO(patente));
        return patenteDTOS;
    }

    public List<PatenteMarcaDTO> allPatentesYMarca(){
        List<Vehiculo> patentesYMarca = repository.obtenerPatenteYMarca();
        List<PatenteMarcaDTO> patenteYMarcaDTOS = new ArrayList<>();
        for (Vehiculo vehiculo : patentesYMarca) {
            patenteYMarcaDTOS.add(new PatenteMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()));
        }
        return patenteYMarcaDTOS;
    }

    @Override
    public List<PatenteMarcaModeloDTO> vehiculosConSiniestrosMayorA10000() {
        List<Vehiculo> vehiculosConSiniestrosMayorA10000 = repository.obtenerVehiculosConSiniestrosMayor10000();
        List<PatenteMarcaModeloDTO> patenteMarcaModeloDTOS = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculosConSiniestrosMayorA10000) {
            patenteMarcaModeloDTOS.add(new PatenteMarcaModeloDTO(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()));
        }
        return patenteMarcaModeloDTOS;
    }

    @Override
    public List<PatenteMarcaModeloSumatoriaDTO> vehiculosAndSumConSiniestrosMayorA10000() {
        List<Object[]> resultados = repository.obtenerMatriculaMarcaModeloConSiniestroMayor10000SumaTotal();
        List<PatenteMarcaModeloSumatoriaDTO> patenteMarcaModeloSumatoriaDTOS = new ArrayList<>();
        for (Object[] resultado : resultados) {
            PatenteMarcaModeloSumatoriaDTO dto = new PatenteMarcaModeloSumatoriaDTO();
            dto.setPatente((String) resultado[0]);
            dto.setMarca((String) resultado[1]);
            dto.setModelo((String) resultado[2]);
            dto.setSumatoria((Double) resultado[3]);
            patenteMarcaModeloSumatoriaDTOS.add(dto);
        }
        return patenteMarcaModeloSumatoriaDTOS;
    }

}
