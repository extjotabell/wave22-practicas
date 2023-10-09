package vehiculosHQL.vehiculosHQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vehiculosHQL.vehiculosHQL.entity.Vehiculo;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> listaPatentes();

    @Query("select v.patente, v.marca from Vehiculo v order by v.añoFabricacion")
    List<Object[]> listaPatenteMarcaAño();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.añoFabricacion = 2023")
    List<String> listaRuedasAño();

    @Query("select v.patente, v.marca, v.modelo from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000")
    List<Object[]> perdidaEconomica();

    @Query("select v.patente, v.marca, v.modelo, sum(s.perdidaEconomica) from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000")
    List<Object[]> perdidaTotal();
}
