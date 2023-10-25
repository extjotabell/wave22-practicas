package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Obtener todas las patentes de los vehiculos
    @Query("SELECT v.patente FROM Vehiculo v")
    Set<String> obtenerTodasLasPatentes();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación
    @Query("SELECT v.patente, v.marca FROM  Vehiculo v ORDER BY v.fabricacion")
    Set<Object[]> obtenerPatenteYMarca();

    /* Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    con pérdida mayor de 10000 pesos. */
    @Query("SELECT v *stro s ON s.idVehiculoDenunciado = v.id WHERE (size(v.siniestros) > 0) and (s.perdidaEconomica > 10000)")
    Set<Vehiculo> obtenerVeSiniestrosMayor10000();

    /*Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.*/
    @Query("SELECT V, SUM(S.perdidaEconomica) FROM Vehiculo V, Siniestro S WHERE V.id=S.idVehiculoDenunciado and S.perdidaEconomica>=10000 GROUP BY V.id")
    HashMap<Vehiculo,Double> obtenerMatriculaMarcaModeloConSiniestroMayor10000SumaTotal();

}
