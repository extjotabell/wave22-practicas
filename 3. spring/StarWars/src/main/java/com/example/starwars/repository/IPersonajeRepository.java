package com.example.starwars.repository;

import com.example.starwars.models.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IPersonajeRepository {

    List<Personaje> getAllPersonajes();
}
