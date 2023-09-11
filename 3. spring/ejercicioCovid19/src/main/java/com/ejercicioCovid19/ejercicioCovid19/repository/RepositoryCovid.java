package com.ejercicioCovid19.ejercicioCovid19.repository;

import com.ejercicioCovid19.ejercicioCovid19.model.Persona;
import com.ejercicioCovid19.ejercicioCovid19.model.Sintoma;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class RepositoryCovid implements IRepositoryCovid{
    private List<Sintoma> sintomasDB;
    private List<Persona> personasDB;

    public RepositoryCovid() {
        loadDatabase();
    }

    @Override
    public List<Sintoma> getAllSintomas(){
        return sintomasDB;
    }

    @Override
    public List<Persona> getAllPersonas(){
        return personasDB;
    }


    @Override
    public void loadDatabase() {
        File sintomasFile = null;
        File personasFile = null;

        try {
            sintomasFile = ResourceUtils.getFile("classpath:sintomas.json");
            personasFile = ResourceUtils.getFile("classpath:personas.json");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Sintoma>> sintomasTypeRef = new TypeReference<>() {};
        TypeReference<List<Persona>> personasTypeRef = new TypeReference<>() {};

        try {
            List<Sintoma> sintomas = objectMapper.readValue(sintomasFile, sintomasTypeRef);
            List<Persona> personas = objectMapper.readValue(personasFile, personasTypeRef);

            System.out.println("Database load successfully!");
            this.sintomasDB = sintomas;
            this.personasDB = personas;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
