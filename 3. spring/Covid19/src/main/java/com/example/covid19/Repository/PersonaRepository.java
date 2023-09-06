package com.example.covid19.Repository;

import com.example.covid19.Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements Repository<Persona,Integer>{

    private List<Persona> personaList;

    public PersonaRepository() {
        this.personaList = new ArrayList<>();

        // Initialize data
        this.initialize();

    }

    public List<Persona> findRiskPerson(){
        return null;
    }

    @Override
    public List<Persona> findAll() {
        return this.personaList;
    }

    @Override
    public Persona find(Integer id) {
        return this.personaList.stream().filter(persona -> persona.getId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public void delete(Integer id) {
        this.personaList.removeIf(persona -> persona.getId().equals(id));
    }

    @Override
    public void add(Persona obj) {
        this.personaList.add(obj);
    }

    private void initialize(){
        SintomasRepository sintomasRepository = new SintomasRepository();

        Persona persona1 = new Persona(1, "Juan", "Pérez", 30, new ArrayList<>());
        Persona persona2 = new Persona(2, "María", "González", 25, new ArrayList<>());
        Persona persona3 = new Persona(3, "Pedro", "López", 61, new ArrayList<>());

        persona1.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona1.getSintomas().add(sintomasRepository.findByName("Tos"));

        persona2.getSintomas().add(sintomasRepository.findByName("Dolor de cabeza"));

        persona3.getSintomas().add(sintomasRepository.findByName("Fatiga"));
        persona3.getSintomas().add(sintomasRepository.findByName("Dolor de garganta"));

        // Agregar personas a la lista
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
    }
}
