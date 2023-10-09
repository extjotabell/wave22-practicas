package com.meli.practicaasyncimpelastic.service;

import com.meli.practicaasyncimpelastic.model.Empleado;
import com.meli.practicaasyncimpelastic.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findByID(String id) {
        return null;
    }

    @Override
    public List<Empleado> findByEdad(String edad) {
        return empleadoRepository.findByEdad(edad);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
