package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.utils.ArmadorPlatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatosRepositoryImpl implements PlatosRepository {
    private List<Plato> listaDePlatos;

    @Autowired
    CaloryRepository caloryRepository;
    ArmadorPlatosService armadorPlatosService;

    public PlatosRepositoryImpl() {
        init();
    }

    @Override
    public List<Plato> getAllPlatos() {
        return listaDePlatos;
    }

    @Override
    public Plato getPlatoLlamado(String nombre) {
        Plato platoBuscado;
        platoBuscado = listaDePlatos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().get();
        return platoBuscado;
    }

    private void init() {
        listaDePlatos = armadorPlatosService.getAllPlatos();

        /*Ingrediente panRallado = caloryRepository.obtenerIngredientePorNombre("Pan de trigo integral"); // TODO: Obtener Ingrediente
        Ingrediente carne = null; // TODO: Obtener Ingrediente
        Map<Ingrediente, Double> mapaDePlato1 = new HashMap<>();
        mapaDePlato1.put(panRallado, 0.5);
        mapaDePlato1.put(carne, 0.5);
        Plato plato1 = new Plato("Milanesa", mapaDePlato1);
        listaDePlatos.add(plato1);

        Ingrediente lechuga = null; // TODO: Obtener Ingrediente
        Ingrediente tomate = null; // TODO: Obtener Ingrediente
        Map<Ingrediente, Double> mapaDePlato2 = new HashMap<>();
        mapaDePlato2.put(lechuga, 0.8);
        mapaDePlato2.put(tomate, 0.2);
        Plato plato2 = new Plato("Ensalada de lechuga y tomate", mapaDePlato2);
        listaDePlatos.add(plato2);

        Ingrediente salsaDeTomate = null; // TODO: Obtener Ingrediente
        Ingrediente harinaDeTrigo = null; // TODO: Obtener Ingrediente
        Ingrediente muzzarella = null; // TODO: Obtener Ingrediente
        Map<Ingrediente, Double> mapaDePlato3 = new HashMap<>();
        mapaDePlato3.put(harinaDeTrigo, 0.4);
        mapaDePlato3.put(muzzarella, 0.3);
        mapaDePlato3.put(salsaDeTomate, 0.3);
        Plato plato3 = new Plato("Pizza", mapaDePlato3);
        listaDePlatos.add(plato3);*/
    }
}
