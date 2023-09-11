package com.example.covid19.repository;

import com.example.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository implements ISintomaRepository{
    List<Sintoma> sintomas = new ArrayList<>();

    private void initialize(){
        Sintoma tos = new Sintoma("AS890", "Tos", 1);
        Sintoma fiebre = new Sintoma("KASDN212", "Fiebre", 8);
        Sintoma gusto = new Sintoma("ADAS1637", "Perdida de gusto", 5);
        Sintoma olfato = new Sintoma("EEWE342", "Perdida de olfato", 5);
        Sintoma aire = new Sintoma("ASDSA9283", "Falta de aire", 10);
        this.sintomas.add(tos);
        this.sintomas.add(fiebre);
        this.sintomas.add(olfato);
        this.sintomas.add(aire);
    }
    @Override
    public List<Sintoma> getAll() {
        if(this.sintomas.isEmpty()){
            initialize();
        }
        return this.sintomas;
    }

    @Override
    public Sintoma findByName(String name) {
        return this.sintomas.stream().filter(sintoma -> sintoma.getNombre().equals(name)).findFirst().get();
    }
}
