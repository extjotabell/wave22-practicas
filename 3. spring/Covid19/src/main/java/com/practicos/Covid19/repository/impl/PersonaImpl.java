package com.practicos.Covid19.repository.impl;
import com.practicos.Covid19.model.Persona;
import com.practicos.Covid19.repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class PersonaImpl implements Repository<Persona, Integer> {

    private List<Persona> personaList;

    public PersonaImpl() {
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
        SintomaImpl sintomasRepository = new SintomaImpl();

        Persona persona1 = new Persona(1,"Persona1", "Apellido1", 18, new ArrayList<>());
        Persona persona2 = new Persona(2,"Persona2", "Apellido2", 24, new ArrayList<>());
        Persona persona3 = new Persona(3,"Persona3", "Apellido3", 36, new ArrayList<>());
        Persona persona4 = new Persona(4,"Persona4", "Apellido4", 45, new ArrayList<>());
        Persona persona5 = new Persona(5,"Persona5", "Apellido5", 57, new ArrayList<>());
        Persona persona6 = new Persona(6,"Persona6", "Apellido6", 66, new ArrayList<>());
        Persona persona7 = new Persona(7,"Persona7", "Apellido7", 67, new ArrayList<>());
        Persona persona8 = new Persona(8,"Persona8", "Apellido8", 68, new ArrayList<>());
        Persona persona9 = new Persona(9,"Persona9", "Apellido9", 69, new ArrayList<>());
        Persona persona10 = new Persona(10,"Persona10", "Apellido10", 70, new ArrayList<>());


        persona1.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona1.getSintomas().add(sintomasRepository.findByName("Tos"));

        persona2.getSintomas().add(sintomasRepository.findByName("Dolor de cabeza"));

        persona3.getSintomas().add(sintomasRepository.findByName("Fatiga"));
        persona3.getSintomas().add(sintomasRepository.findByName("Dolor de garganta"));
        persona4.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona5.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona6.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona7.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona8.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona9.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona10.getSintomas().add(sintomasRepository.findByName("Fiebre"));
        persona10.getSintomas().add(sintomasRepository.findByName("Fatiga"));

        // Agregar personas a la lista
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        personaList.add(persona4);
        personaList.add(persona5);
        personaList.add(persona6);
        personaList.add(persona7);
        personaList.add(persona8);
        personaList.add(persona9);
        personaList.add(persona10);
    }
}
