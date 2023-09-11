package com.example.deportistas.service;

import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.model.Persona;
import com.example.deportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    List<DeportistaDTO> deportistas = new ArrayList<>();

    @Autowired
    PersonaRepository repository;
    @Override
    public List<Persona> getAll() {
        return repository.getAll();
    }

    private void initialize(){
        var maria = new DeportistaDTO("Maria", "Lopez", "Natacion");
        var pablo = new DeportistaDTO("Pablo", "Gomez", "Atletismo");
        var juana = new DeportistaDTO("Juana", "Sanchez", "Basquet");
        this.deportistas.add(maria);
        this.deportistas.add(pablo);
        this.deportistas.add(juana);
    }

    public List<DeportistaDTO> getAllDeportistas(){
        initialize();
        return this.deportistas;
    }
}
