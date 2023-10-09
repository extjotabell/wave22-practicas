package com.example.empresaseguros.repository;

import com.example.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query("SELECT v.patente FROM Vehiculo v")
    public List<Vehiculo> obtenerTodasLasPatentes();

    @Query("SELECT v.marca, v.patente FROM Vehiculo v ORDER BY v.añoFabricacion")
    public List<Vehiculo> obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND year(v.añoFabricacion) = year(current_date())")
    public List<Vehiculo> patentesMasDe4RuedasDeEsteAño();

    /*INSERT INTO `VEHICULOS` (`AÑO_FABRICACION` ,`CANTIDAD_RUEDAS` , `MARCA` ,`MODELO` ,`PATENTE` )
    VALUES
            ('2017-01-01', 4, 'Toyota', 'Etios', 'AA111AA'),
 ('2017-02-01', 4, 'Toyota', 'Etios', 'AB123XZ'),
         ('2018-04-01', 4, 'Chevrolet', 'Cruze', 'AC323VF'),
         ('2019-01-01', 2, 'Toyota', 'Corolla', 'AD543VX'),
         ('2018-02-01', 2, 'Ford', 'Fiesta', 'AC564YZ'),
         ('2020-01-01', 4, 'Toyota', 'Etios', 'AD987ZX'),
         ('2022-02-01', 4, 'Peugeot', '3008', 'AE111AA'),
         ('2023-06-01', 2, 'Ford', 'Ranger', 'AF111AA'),
         ('2023-11-01', 4, 'Batimovil', 'Robin', 'AF176GE'),
         ('2023-06-01', 4, 'Toyota', 'SW4', 'AG843IP');*/
}
