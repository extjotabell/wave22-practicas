package com.meli.practicaasyncimpelastic.service;

import com.meli.practicaasyncimpelastic.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> findAll();
    Empleado findByID(String id);

    List<Empleado> findByEdad(String edad);

    Empleado save(Empleado empleado);


}
