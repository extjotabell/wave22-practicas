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
    @Query("SELECT NEW com.movies.demoHQL.model.Vehiculo(v.patente,v.marca) FROM Vehiculo v ORDER BY v.fabricacion")
    List<Vehiculo> obtenerPatenteYMarca();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT DISTINCT NEW com.movies.demoHQL.model.Vehiculo(V.patente,V.modelo, V.marca) FROM Vehiculo V JOIN Siniestro S ON V.id=S.idVehiculoDenunciado WHERE S.perdidaEconomica > 10000")
    List<Vehiculo> obtenerVehiculosConSiniestrosMayor10000();
//
    ///*Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    //con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.*/
    //@Query("SELECT V, SUM(S.perdidaEconomica) FROM Vehiculo V, Siniestro S WHERE V.id=S.idVehiculoDenunciado and S.perdidaEconomica>=10000 GROUP BY V.id")
    @Query("SELECT V.patente, V.marca, V.modelo, SUM(S.perdidaEconomica) FROM Vehiculo V, Siniestro S WHERE V.id=S.idVehiculoDenunciado and S.perdidaEconomica>=10000 GROUP BY V.id")
    List<Object[]> obtenerMatriculaMarcaModeloConSiniestroMayor10000SumaTotal();

}
