package com.meli.practicaasyncimpelastic.repository;

import com.meli.practicaasyncimpelastic.model.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado,String> {

    List<Empleado> findAll();

    @Query("{\"bool\": {\"filter\": [{\"ferm\": {\"edad\": \"?0\"}}]}}")
    List<Empleado> findByEdad(String edad);
}
