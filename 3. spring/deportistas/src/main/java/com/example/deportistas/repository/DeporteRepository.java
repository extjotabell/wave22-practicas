package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository{
    List<Deporte> deportes = new ArrayList<>();

    private void initialize(){
        var natacion = new Deporte("natacion", 5);
        var atletismo = new Deporte("Atletismo", 10);
        var basquet = new Deporte("basquet", 8);
        this.deportes.add(natacion);
        this.deportes.add(atletismo);
        this.deportes.add(basquet);
    }

    @Override
    public List<Deporte> getAll() {
        initialize();
        return this.deportes;
    }

    @Override
    public Deporte getByName(String name) {
        initialize();
        return this.deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().get();
    }
}
