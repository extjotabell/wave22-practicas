package com.example.demo.services;

import co.elastic.clients.elasticsearch.ml.Page;
import com.example.demo.domain.Empleado;
import com.example.demo.elasticrepositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    public List<Empleado> getAllByEdad(String edad){
        return empleadoRepository.findByEdad(edad);
    }

    public List<Empleado> getEmpleadoByNombreAndCiudad(String nombre, String orden){
        if(orden.equalsIgnoreCase("asc"))
            return empleadoRepository.findEmpleadoByNombreStartingWith(nombre, Sort.by("nombre").ascending());
        else
            return empleadoRepository.findEmpleadoByNombreStartingWith(nombre, Sort.by("nombre").descending());
    }

    public List<Empleado> getEmpleadoByMascota(String mascota){
        return empleadoRepository.findEmpleadoByMascotasContains(mascota);
    }
}
